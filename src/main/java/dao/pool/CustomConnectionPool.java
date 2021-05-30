package dao.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Enumeration;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomConnectionPool {

    private static CustomConnectionPool instance;

    private BlockingQueue<ProxyConnection> availableConnections;

    private Queue<ProxyConnection> givenAwayConnections;

    private static Lock lock = new ReentrantLock();

    private static AtomicBoolean create = new AtomicBoolean(false);

    private static final Logger logger = LogManager.getLogger();

    private CustomConnectionPool() {
        registerDriver();
        init();
    }

    private void registerDriver() {
        try {
            Class.forName(ConnectionProperty.DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        availableConnections= new LinkedBlockingDeque<>(ConnectionProperty.DEFAULT_POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();

        for (int i = 0; i < ConnectionProperty.DEFAULT_POOL_SIZE; i++) {
            try {
                Connection connection = DriverManager.getConnection(
                        ConnectionProperty.DATABASE_URL, ConnectionProperty.DATABASE_USERNAME,
                        ConnectionProperty.DATABASE_PASSWORD);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                availableConnections.offer(proxyConnection);
            } catch (SQLException throwables) {
                //TODO log
                throwables.printStackTrace(); //TODO del
            }
        }


        //TODO проверить есть ли конекшны в пуле и бросить рантайм если их 0 Exception in initializerError
        //TODO если соединений меньше чем в файле досоздать до нужного количества
        //TODO fatal exception если нет файла или данных в файле
    }

    public static CustomConnectionPool getInstance() {
        if(!create.get()) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new CustomConnectionPool();
                    create.set(true);
                }
            } finally {
                lock.unlock();
            }
        }

        return instance;
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = availableConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            //TODO log
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        //TODO проверка на ProxyConnection и вернуть исключение если конекшн не наш неProxy Connection getCalss методом
        ProxyConnection proxyConnection = (ProxyConnection) connection;
        givenAwayConnections.remove(proxyConnection);
        availableConnections.offer(proxyConnection);
    }

    public void destroyPool() {
        for (int i = 0; i < ConnectionProperty.DEFAULT_POOL_SIZE; i++) {
            try {
                availableConnections.take().realClose();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver currentDriver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(currentDriver);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}

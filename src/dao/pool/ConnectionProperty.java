package dao.pool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class ConnectionProperty {
    //TODO constants

    static {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("database.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        DRIVER_CLASS_NAME = properties.getProperty("driver.class.name");
        DATABASE_URL = properties.getProperty("db.url");
        DATABASE_USERNAME = properties.getProperty("db.username");
        DATABASE_PASSWORD = properties.getProperty("db.password");
        DEFAULT_POOL_SIZE = Integer.parseInt(properties.getProperty("default.pool.size"));
    }

    public static final String DRIVER_CLASS_NAME;

    public static final String DATABASE_URL;

    public static final String DATABASE_USERNAME ;

    public static final String DATABASE_PASSWORD;

    public static final int DEFAULT_POOL_SIZE;

}


import dao.pool.CustomConnectionPool;
import dao.impl.UserDetailDaoImpl;
import dao.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;

public class Runner {

    static final Logger rootLogger = LogManager.getRootLogger();
//    static final Logger userLogger = LogManager.getLogger(User.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Connection connection = CustomConnectionPool.getInstance().getConnection();
//
//            Statement statement = connection.createStatement();
//            ResultSet result = statement.executeQuery("select * from users");
////        UserDetail userDetail = new UserDetail();
////        userDetail.setFirstName("124");
////        userDetail.setLastName("124");
////        userDetail.setCompany("124");
////        userDetail.setPosition("124");
////        userDetail.setExperience("234");
////        userDetail.setSalary(12);
////        userDetail.setStatus("24");
////        UserDetailDaoImpl dao = new UserDetailDaoImpl();
////        dao.addUserDetail(userDetail);
//
//            while (result.next()) {
//                System.out.println(result.getString("login"));
//            }


        Connection connection = CustomConnectionPool.getInstance().getConnection();
        Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from users");
        while (result.next()) {
                System.out.println(result.getString("login"));
            }

    }
}

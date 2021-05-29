import dao.ConnectionPool;
import dao.impl.UserDetailDaoImpl;
import entity.UserDetail;

import java.sql.*;

public class Runner {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionPool.getConnection();

//            Statement statement = connection.createStatement();
//            ResultSet result = statement.executeQuery("select * from users");
            UserDetail userDetail = new UserDetail();
            userDetail.setFirstName("124");
            userDetail.setLastName("124");
            userDetail.setCompany("124");
            userDetail.setPosition("124");
            userDetail.setExperience("234");
            userDetail.setSalary(12);
            userDetail.setStatus("24");
            UserDetailDaoImpl dao = new UserDetailDaoImpl();
            dao.addUserDetail(userDetail);

//            while (result.next()) {
//                System.out.println(result.getString("login"));
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

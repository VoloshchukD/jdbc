package dao;

import entity.UserDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDetailDAO {

    private static final String SQL_ADD_USER = "INSERT INTO user_details (first_name, " +
            "last_name, company, position, experience, salary, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public boolean addUserDetail(UserDetail userDetail) {
        boolean isAdded = false;

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER);
            statement.setString(1, userDetail.getFirstName());
            statement.setString(2, userDetail.getLastName());
            statement.setString(3, userDetail.getCompany());
            statement.setString(4, userDetail.getPosition());
            statement.setString(5, userDetail.getExperience());
            statement.setString(6, userDetail.getSalary().toString());
            statement.setString(7, userDetail.getStatus());
            isAdded = statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isAdded;
    }

    public void findUserDetailById(Long id) {

    }

    public void updateUserDetail(UserDetail userDetail) {

    }

    public void removeUserDetailById(Long id) {

    }

}

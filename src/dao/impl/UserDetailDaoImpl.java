package dao.impl;

import dao.ConnectionPool;
import entity.UserDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetailDaoImpl {

    private static final String SQL_ADD_USER_DETAIL = "INSERT INTO user_details (first_name, " +
            "last_name, company, position, experience, salary, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_FIND_USER_DETAIL = "SELECT * FROM user_details where id = ?";

    private static final String SQL_UPDATE_USER_DETAIL = "UPDATE user_details SET first_name = ?, " +
            "last_name = ?, company = ?, position = ?, experience = ?, salary = ?, status = ? WHERE id = ?";

    public boolean addUserDetail(UserDetail userDetail) {
        boolean isAdded = false;

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER_DETAIL);
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

    public UserDetail findUserDetailById(Long id) {
        UserDetail userDetail = null;

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_DETAIL);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();

            userDetail = new UserDetail();
            userDetail.setId(Long.valueOf(resultSet.getString("id")));
            userDetail.setFirstName(resultSet.getString("firstName"));
            userDetail.setLastName(resultSet.getString("lastName"));
            userDetail.setCompany(resultSet.getString("company"));
            userDetail.setPosition(resultSet.getString("position"));
            userDetail.setExperience(resultSet.getString("experience"));
            userDetail.setSalary(Integer.parseInt(resultSet.getString("salary")));
            userDetail.setStatus(resultSet.getString("status"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userDetail;
    }

    public UserDetail updateUserDetail(UserDetail userDetail) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER_DETAIL);
            statement.setString(1, userDetail.getFirstName());
            statement.setString(2, userDetail.getLastName());
            statement.setString(3, userDetail.getCompany());
            statement.setString(4, userDetail.getPosition());
            statement.setString(5, userDetail.getExperience());
            statement.setString(6, String.valueOf(userDetail.getSalary()));
            statement.setString(7, userDetail.getStatus());
            statement.setString(8, String.valueOf(userDetail.getId()));

            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userDetail;
    }

    public boolean removeUserDetailById(Long id) {

        return false;
    }

}

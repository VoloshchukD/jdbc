package by.voloshchuk.dao.impl;

import by.voloshchuk.dao.UserDetailDao;
import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.UserDetail;
import by.voloshchuk.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDetailDaoImpl implements UserDetailDao {

    private static final String SQL_ADD_USER_DETAIL = "INSERT INTO user_details (first_name, " +
            "last_name, company, position, experience, salary, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_FIND_USER_DETAIL_BY_ID = "SELECT * FROM user_details where id = ?";

    private static final String SQL_UPDATE_USER_DETAIL = "UPDATE user_details SET first_name = ?, " +
            "last_name = ?, company = ?, position = ?, experience = ?, salary = ?, status = ? WHERE id = ?";

    private static final String SQL_DELETE_USER_DETAIL = "DELETE FROM user_details WHERE id = ?";

    private CustomConnectionPool connectionPool = CustomConnectionPool.getInstance();

    public boolean addUserDetail(UserDetail userDetail) throws DaoException {
        boolean isAdded = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER_DETAIL)) {
            statement.setString(1, userDetail.getFirstName());
            statement.setString(2, userDetail.getLastName());
            statement.setString(3, userDetail.getCompany());
            statement.setString(4, userDetail.getPosition());
            statement.setString(5, userDetail.getExperience().toString());
            statement.setString(6, userDetail.getSalary().toString());
            statement.setString(7, userDetail.getStatus());
            isAdded = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isAdded;
    }

    public UserDetail findUserDetailById(Long id) throws DaoException {
        UserDetail userDetail = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_DETAIL_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            userDetail = new UserDetail();
            if (resultSet.next()) {
                userDetail.setId(Long.valueOf(resultSet.getString(ConstantColumnName.ID)));
                userDetail.setFirstName(resultSet.getString(ConstantColumnName.USER_DETAIL_FIRST_NAME));
                userDetail.setLastName(resultSet.getString(ConstantColumnName.USER_DETAIL_LAST_NAME));
                userDetail.setCompany(resultSet.getString(ConstantColumnName.USER_DETAIL_COMPANY));
                userDetail.setPosition(resultSet.getString(ConstantColumnName.USER_DETAIL_POSITION));
                userDetail.setExperience(Integer.parseInt(resultSet.getString(ConstantColumnName.USER_DETAIL_EXPERIENCE)));
                userDetail.setSalary(Integer.parseInt(resultSet.getString(ConstantColumnName.USER_DETAIL_SALARY)));
                userDetail.setStatus(resultSet.getString(ConstantColumnName.USER_DETAIL_STATUS));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return userDetail;
    }

    public List<UserDetail> findAll() throws DaoException {
        return null;
    }

    public UserDetail updateUserDetail(UserDetail userDetail) throws DaoException {
        UserDetail resultUserDetail = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER_DETAIL)) {
            statement.setString(1, userDetail.getFirstName());
            statement.setString(2, userDetail.getLastName());
            statement.setString(3, userDetail.getCompany());
            statement.setString(4, userDetail.getPosition());
            statement.setString(5, String.valueOf(userDetail.getExperience()));
            statement.setString(6, String.valueOf(userDetail.getSalary()));
            statement.setString(7, userDetail.getStatus());
            statement.setString(8, String.valueOf(userDetail.getId()));
            int result = statement.executeUpdate();
            if (result == 1) {
                resultUserDetail = userDetail;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return resultUserDetail;
    }

    public boolean removeUserDetailById(Long id) throws DaoException {
        boolean isRemoved = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER_DETAIL)) {
            statement.setString(1, String.valueOf(id));
            isRemoved = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isRemoved;
    }

}

package by.voloshchuk.dao.impl;

import by.voloshchuk.dao.UserDao;
import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.EmployeeRequirement;
import by.voloshchuk.entity.User;
import by.voloshchuk.entity.UserDetail;
import by.voloshchuk.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//USERS//
//INSERT INTO `teams`.`users` (`email`, `password`, `role`, `user_detail_id`) VALUES ('sato1224@gmail.com', 'qwq34g34erty123', 'customer', '1');
//        UPDATE `teams`.`users` SET `password` = 'zsdbdgh' WHERE (`user_id` = '1');
//        DELETE FROM `teams`.`users` WHERE (`user_id` = '1');
//        SELECT * FROM teams.users WHERE email='sato1224@gmail.com'
//for user-manager to find developers for project
//        SELECT * FROM teams.users INNER JOIN teams.user_details ON teams.users.user_id = teams.user_details.user_detail_id WHERE teams.users.role='developer' AND teams.user_details.experience >= 1
//        AND teams.user_details.salary <= 10000 AND teams.user_details.primary_skill = "C"
//for user-manager to look for work
//        SELECT * FROM teams.technical_tasks WHERE teams.technical_tasks.status = 'WAITING_PROJECT'

//MAPS//
//        INSERT INTO `teams`.`user_project_maps` (`project_id`, `user_id`) VALUES ('1', '3');
//        DELETE FROM `teams`.`user_project_maps` WHERE (`user_project_map_id` = '1');

public class UserDaoImpl implements UserDao {

    private static final String SQL_ADD_USER = "INSERT INTO users (email, " +
            "password, role, user_detail_id) VALUES (?, ?, ?, ?)";

    private static final String SQL_FIND_USER_BY_ID = "SELECT * FROM users INNER JOIN user_details " +
            "ON users.user_detail_id = user_details.user_detail_id " +
            "WHERE user_id = ?";

    //TODO WHERE teams.users.role='developer' AND teams.user_details.experience >= 1
    // AND teams.user_details.salary <= 10000 AND teams.user_details.primary_skill = "Node.js"
    private static final String SQL_FIND_USER_BY_REQUIREMENT = "SELECT * FROM users " +
            "INNER JOIN user_details ON users.user_id = user_details.user_detail_id WHERE role='developer' " +
            "AND experience >= ? AND salary <= ? AND position = ?";

    private static final String SQL_UPDATE_USER = "UPDATE users SET email = ?, " +
            "password = ?, role = ?, user_detail_id = ? WHERE user_id = ?";

    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE user_id = ?";

    private CustomConnectionPool connectionPool = CustomConnectionPool.getInstance();

    public boolean addUser(User user) throws DaoException {
        boolean isAdded = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setString(4, String.valueOf(user.getUserDetail().getId()));
            isAdded = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isAdded;
    }

    public User findUserById(Long id) throws DaoException {
        User user = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            user = new User();
            if (resultSet.next()) {
                user.setId(Long.valueOf(resultSet.getString(ConstantColumnName.USER_ID)));
                user.setEmail(resultSet.getString(ConstantColumnName.USER_EMAIL));
                user.setPassword(resultSet.getString(ConstantColumnName.USER_PASSWORD));
                user.setRole(resultSet.getString(ConstantColumnName.USER_ROLE));

                UserDetail userDetail = new UserDetail();
                userDetail.setId(Long.valueOf(resultSet.getString(ConstantColumnName.USER_DETAIL_ID)));
                userDetail.setFirstName(resultSet.getString(ConstantColumnName.USER_DETAIL_FIRST_NAME));
                userDetail.setLastName(resultSet.getString(ConstantColumnName.USER_DETAIL_LAST_NAME));
                userDetail.setCompany(resultSet.getString(ConstantColumnName.USER_DETAIL_COMPANY));
                userDetail.setPosition(resultSet.getString(ConstantColumnName.USER_DETAIL_POSITION));
                userDetail.setExperience(Integer.parseInt(resultSet.getString(ConstantColumnName.USER_DETAIL_EXPERIENCE)));
                userDetail.setSalary(Integer.parseInt(resultSet.getString(ConstantColumnName.USER_DETAIL_SALARY)));
                userDetail.setPrimarySkill(resultSet.getString(ConstantColumnName.USER_DETAIL_PRIMARY_SKILL));
                userDetail.setSkillsDescription(resultSet.getString(ConstantColumnName.USER_DETAIL_SKILLS_DESCRIPTION));
                userDetail.setStatus(resultSet.getString(ConstantColumnName.USER_DETAIL_STATUS));
                user.setUserDetail(userDetail);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    //TODO user details update
    public User updateUser(User user) throws DaoException {
        User resultUser = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setString(4, String.valueOf(user.getUserDetail().getId()));
            statement.setString(5, String.valueOf(user.getId()));
            int result = statement.executeUpdate();
            if (result == 1) {
                resultUser = user;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return resultUser;
    }

    //TODO user details delete
    public boolean removeUserById(Long id) throws DaoException {
        boolean isRemoved = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER)) {
            User user = findUserById(id);
            statement.setString(1, String.valueOf(id));
            isRemoved = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isRemoved;
    }

    public List<User> findAllByEmployeeRequirement(EmployeeRequirement requirements) throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_REQUIREMENT)) {
            statement.setString(1, String.valueOf(requirements.getExperience()));
            statement.setString(2, String.valueOf(requirements.getSalary()));
            statement.setString(3, String.valueOf(requirements.getQualification()));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                UserDetail userDetail = new UserDetail();

                userDetail.setId(Long.valueOf(resultSet.getString(ConstantColumnName.USER_DETAIL_ID)));
                userDetail.setFirstName(resultSet.getString(ConstantColumnName.USER_DETAIL_FIRST_NAME));
                userDetail.setLastName(resultSet.getString(ConstantColumnName.USER_DETAIL_LAST_NAME));
                userDetail.setCompany(resultSet.getString(ConstantColumnName.USER_DETAIL_COMPANY));
                userDetail.setPosition(resultSet.getString(ConstantColumnName.USER_DETAIL_POSITION));
                userDetail.setExperience(Integer.parseInt(resultSet.getString(ConstantColumnName.USER_DETAIL_EXPERIENCE)));
                userDetail.setSalary(Integer.parseInt(resultSet.getString(ConstantColumnName.USER_DETAIL_SALARY)));
                userDetail.setStatus(resultSet.getString(ConstantColumnName.USER_DETAIL_STATUS));

                user.setId(Long.valueOf(resultSet.getString(ConstantColumnName.USER_ID)));
                user.setEmail(resultSet.getString(ConstantColumnName.USER_EMAIL));
                user.setPassword(resultSet.getString(ConstantColumnName.USER_PASSWORD));
                user.setRole(resultSet.getString(ConstantColumnName.USER_ROLE));
                user.setUserDetail(userDetail);

                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return users;
    }

}

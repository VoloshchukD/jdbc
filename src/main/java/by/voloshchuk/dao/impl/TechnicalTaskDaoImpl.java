package by.voloshchuk.dao.impl;

import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.TechnicalTask;
import by.voloshchuk.entity.User;
import by.voloshchuk.entity.UserDetail;
import by.voloshchuk.exception.DaoException;

import java.sql.*;
//TECHNICAL_TASKS//
//        INSERT INTO `teams`.`technical_tasks` (`overview`, `deadline`, `workers_amount`, `status`, `customer_id`) VALUES ('Legacy code bug fix and patch', '2022-07-24 12:00:00', '2', 'WAIT_PROJECT', '4');
//        UPDATE `teams`.`technical_tasks` SET `overview` = 'Legacy code bug fix and patch', `deadline` = '2023-11-18 19:00:00', `workers_amount` = '2', `status` = 'ON_PROJECT' WHERE (`technical_task_id` = '1');
//        DELETE FROM `teams`.`technical_tasks` WHERE (`technical_task_id` = '10');
//for user-customer to view his technical tasks
//        SELECT * FROM teams.technical_tasks WHERE teams.technical_tasks.customer_id = 1
public class TechnicalTaskDaoImpl {

    private static final String SQL_ADD_TECHNICAL_TASK = "INSERT INTO technical_tasks (overview, " +
            "deadline, workers_amount, customer_id) " +
            "VALUES (?, ?, ?, ?)";

//    private static final String SQL_FIND_TECHNICAL_TASK_BY_ID = "SELECT * FROM technical_tasks " +
//            "WHERE technical_task_id = ?";

    private static final String SQL_FIND_TECHNICAL_TASK_BY_ID =
            "SELECT * FROM technical_tasks INNER JOIN users " +
                    "ON users.user_id = technical_tasks.customer_id " +
                    "INNER JOIN user_details ON users.user_id = user_details.user_detail_id " +
                    "WHERE technical_tasks.technical_task_id = ?";

    private static final String SQL_UPDATE_TECHNICAL_TASK = "UPDATE technical_tasks SET overview = ?, " +
            "deadline = ?, workers_amount = ?, customer_id = ? WHERE technical_task_id = ?";

    private static final String SQL_DELETE_TECHNICAL_TASK = "DELETE FROM technical_tasks " +
            "WHERE technical_task_id = ?";

    private CustomConnectionPool connectionPool = CustomConnectionPool.getInstance();

    public boolean addTechnicalTask(TechnicalTask technicalTask) throws DaoException {
        boolean isAdded = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_TECHNICAL_TASK)) {
            statement.setString(1, technicalTask.getOverview());
            statement.setTimestamp(2, new Timestamp(technicalTask.getDeadline().getTime()));
            statement.setString(3, String.valueOf(technicalTask.getWorkersAmount()));
            statement.setString(4, String.valueOf(technicalTask.getCustomer().getId()));
            isAdded = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isAdded;
    }

    public TechnicalTask findTechnicalTaskById(Long id) throws DaoException {
        TechnicalTask technicalTask = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_TECHNICAL_TASK_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            technicalTask = new TechnicalTask();
            if (resultSet.next()) {
                technicalTask.setId(Long.valueOf(resultSet.getString(ConstantColumnName.TECHNICAL_TASK_ID)));
                Timestamp timestamp = resultSet.getTimestamp(ConstantColumnName.TECHNICAL_TASK_DEADLINE);
                Date date = new Date(timestamp.getTime());
                technicalTask.setDeadline(date);
                technicalTask.setOverview(resultSet.getString(ConstantColumnName.TECHNICAL_TASK_OVERVIEW));
                technicalTask.setWorkersAmount(Integer.parseInt(resultSet.getString(
                        ConstantColumnName.TECHNICAL_TASK_WORKERS_AMOUNT)));

                User user = new User();
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
                technicalTask.setCustomer(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return technicalTask;
    }

    public TechnicalTask updateTechnicalTask(TechnicalTask technicalTask) throws DaoException {
        TechnicalTask resultTechnicalTask = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_TECHNICAL_TASK)) {
            statement.setString(1, technicalTask.getOverview());
            statement.setTimestamp(2, new Timestamp(technicalTask.getDeadline().getTime()));
            statement.setString(3, String.valueOf(technicalTask.getWorkersAmount()));
            statement.setString(4, String.valueOf(technicalTask.getCustomer().getId()));
            statement.setString(5, String.valueOf(technicalTask.getId()));
            int result = statement.executeUpdate();
            if (result == 1) {
                resultTechnicalTask = technicalTask;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return resultTechnicalTask;
    }

    public boolean removeTechnicalTask(Long id) throws DaoException {
        boolean isRemoved = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_TECHNICAL_TASK)) {
            statement.setString(1, String.valueOf(id));
            isRemoved = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isRemoved;
    }

}

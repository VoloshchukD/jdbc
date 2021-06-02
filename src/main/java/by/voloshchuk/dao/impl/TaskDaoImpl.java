package by.voloshchuk.dao.impl;

import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.Project;
import by.voloshchuk.entity.Task;
import by.voloshchuk.entity.User;
import by.voloshchuk.exception.DaoException;

import java.sql.*;

public class TaskDaoImpl {

    private static final String SQL_ADD_TASK = "INSERT INTO tasks (name, " +
            "details, hours, status, project_id, developer_id) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_FIND_TASK_BY_ID = "SELECT * FROM tasks WHERE task_id = ?";

    private static final String SQL_UPDATE_TASK = "UPDATE tasks SET name = ?, details = ?," +
            " hours = ?, status = ?, project_id = ?, developer_id = ? WHERE task_id = ?";

    private static final String SQL_DELETE_TASK = "DELETE FROM tasks WHERE task_id = ?";

    private CustomConnectionPool connectionPool = CustomConnectionPool.getInstance();

    public boolean addTask(Task task) throws DaoException {
        boolean isAdded = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_TASK)) {
            statement.setString(1, task.getName());
            statement.setString(2, task.getDetails());
            statement.setString(3, String.valueOf(task.getHours()));
            statement.setString(4, task.getStatus());
            statement.setString(5, String.valueOf(task.getProject().getId()));
            statement.setString(6, String.valueOf(task.getDeveloper().getId()));
            isAdded = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isAdded;
    }

    public Task findTaskById(Long id) throws DaoException {
        Task task = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_TASK_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            task = new Task();
            if (resultSet.next()) {
                task.setId(Long.valueOf(resultSet.getString(ConstantColumnName.TASK_ID)));
                task.setName(resultSet.getString(ConstantColumnName.TASK_NAME));
                task.setDetails(resultSet.getString(ConstantColumnName.TASK_DETAILS));
                task.setHours(Integer.parseInt(resultSet.getString(ConstantColumnName.TASK_HOURS)));
                task.setStatus(resultSet.getString(ConstantColumnName.TASK_STATUS));
//     TODO          task.setProject();
//     TODO           task.setDeveloper();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return task;
    }

    public Task updateTask(Task task) throws DaoException {
        Task resultTask = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_TASK)) {
            statement.setString(1, task.getName());
            statement.setString(2, task.getDetails());
            statement.setString(3, String.valueOf(task.getHours()));
            statement.setString(4, task.getStatus());
            statement.setString(5, String.valueOf(task.getProject().getId()));
            statement.setString(6, String.valueOf(task.getDeveloper().getId()));
            statement.setString(7, String.valueOf(task.getId()));

            int result = statement.executeUpdate();
            if (result == 1) {
                resultTask = task;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return resultTask;
    }

    public boolean removeTask(Long id) throws DaoException {
        boolean isRemoved = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_TASK)) {
            statement.setString(1, String.valueOf(id));
            isRemoved = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isRemoved;
    }

}

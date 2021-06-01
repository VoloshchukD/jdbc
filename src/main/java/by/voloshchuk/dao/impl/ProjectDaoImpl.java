package by.voloshchuk.dao.impl;

import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.Project;
import by.voloshchuk.exception.DaoException;

import java.sql.*;

public class ProjectDaoImpl {

    private static final String SQL_ADD_PROJECT = "INSERT INTO projects (start_date, " +
            "status, payment, technical_task_id) " +
            "VALUES (?, ?, ?, ?)";

    private static final String SQL_FIND_PROJECT_BY_ID = "SELECT * FROM projects WHERE project_id = ?";

    private static final String SQL_UPDATE_PROJECT = "UPDATE projects SET start_date = ?, status = ?," +
            " payment = ?, technical_task_id = ? WHERE project_id = ?";

    private static final String SQL_DELETE_PROJECT = "DELETE FROM projects WHERE project_id = ?";

    private CustomConnectionPool connectionPool = CustomConnectionPool.getInstance();

    public boolean addProject(Project project) throws DaoException {
        boolean isAdded = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_PROJECT)) {
            statement.setTimestamp(1, new Timestamp(project.getStartDate().getTime()));
            statement.setString(2, project.getStatus());
            statement.setString(3, String.valueOf(project.getPayment()));
            statement.setString(4, String.valueOf(project.getTechnicalTask().getId()));
            isAdded = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isAdded;
    }

    public Project findProjectById(Long id) throws DaoException {
        Project project = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_PROJECT_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            project = new Project();
            if (resultSet.next()) {
                project.setId(Long.valueOf(resultSet.getString(ConstantColumnName.PROJECT_ID)));

                Timestamp timestamp = resultSet.getTimestamp(ConstantColumnName.PROJECT_START_DATE);
                Date date = new Date(timestamp.getTime());
                project.setStartDate(date);
                project.setStatus(resultSet.getString(ConstantColumnName.PROJECT_STATUS));
                project.setPayment(Integer.parseInt(resultSet.getString(ConstantColumnName.PROJECT_PAYMENT)));
//              TODO  project.setTechnicalTask();

            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return project;
    }

    public Project updateProject(Project project) throws DaoException {
        Project resultProject = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PROJECT)) {
            statement.setTimestamp(1, new Timestamp(project.getStartDate().getTime()));
            statement.setString(2, project.getStatus());
            statement.setString(3, String.valueOf(project.getPayment()));
            statement.setString(4, String.valueOf(project.getTechnicalTask().getId()));
            statement.setString(5, String.valueOf(project.getId()));
            int result = statement.executeUpdate();
            if (result == 1) {
                resultProject = project;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return resultProject;
    }

    public boolean removeProject(Long id) throws DaoException {
        boolean isRemoved = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PROJECT)) {
            statement.setString(1, String.valueOf(id));
            isRemoved = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isRemoved;
    }

}

package by.voloshchuk.dao.impl;

import by.voloshchuk.dao.EmployeeRequirementDao;
import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.EmployeeRequirement;
import by.voloshchuk.entity.TechnicalTask;
import by.voloshchuk.entity.User;
import by.voloshchuk.entity.UserDetail;
import by.voloshchuk.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRequirementDaoImpl implements EmployeeRequirementDao {

    private static final String SQL_ADD_EMPLOYEE_REQUIREMENT = "INSERT INTO employee_requirements (experience, " +
            "salary, qualification, primary_skill, comment, technical_task_id) VALUES (?, ?, ?, ?, ?, ?)";

//    private static final String SQL_FIND_EMPLOYEE_REQUIREMENT_BY_ID = "SELECT * FROM employee_requirements WHERE " +
//            "employee_requirement_id = ?";

    private static final String SQL_FIND_EMPLOYEE_REQUIREMENT_BY_ID =
        "SELECT * FROM employee_requirements INNER JOIN technical_tasks " +
            "ON employee_requirements.technical_task_id = technical_tasks.technical_task_id " +
            "INNER JOIN users ON technical_tasks.customer_id = users.user_id " +
            "INNER JOIN user_details ON users.user_id = user_details.user_detail_id " +
            "WHERE employee_requirements.employee_requirement_id = ?";

    private static final String SQL_FIND_ALL_BY_TECHNICAL_TASK_ID = "SELECT * FROM employee_requirements " +
            "WHERE technical_task_id = ?";

    private static final String SQL_UPDATE_EMPLOYEE_REQUIREMENT = "UPDATE employee_requirements SET experience = ?, " +
            "salary = ?, qualification = ?, primary_skill = ?, comment = ?, technical_task_id = ? " +
            "WHERE employee_requirement_id = ?";

    private static final String SQL_DELETE_EMPLOYEE_REQUIREMENT = "DELETE FROM employee_requirements " +
            "WHERE employee_requirement_id = ?";

    private CustomConnectionPool connectionPool = CustomConnectionPool.getInstance();

    public boolean addEmployeeRequirement(EmployeeRequirement requirement) throws DaoException {
        boolean isAdded = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_EMPLOYEE_REQUIREMENT)) {
            statement.setString(1, String.valueOf(requirement.getExperience()));
            statement.setString(2, String.valueOf(requirement.getSalary()));
            statement.setString(3, requirement.getQualification());
            statement.setString(4, requirement.getPrimarySkill());
            statement.setString(5, requirement.getComment());
            statement.setString(6, String.valueOf(requirement.getTechnicalTask().getId()));
            isAdded = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isAdded;
    }

    public EmployeeRequirement findEmployeeRequirementById(Long id) throws DaoException {
        EmployeeRequirement requirement = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_EMPLOYEE_REQUIREMENT_BY_ID)) {
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            requirement = new EmployeeRequirement();
            if (resultSet.next()) {
                requirement.setId(Long.valueOf(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_ID)));
                requirement.setExperience(Integer.valueOf(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_EXPERIENCE)));
                requirement.setSalary(Integer.valueOf(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_SALARY)));
                requirement.setQualification(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_QUALIFICATION));
                requirement.setPrimarySkill(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_PRIMARY_SKILL));
                requirement.setComment(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_COMMENT));

                TechnicalTask technicalTask = new TechnicalTask();
                technicalTask.setId(Long.parseLong(resultSet.getString(ConstantColumnName.TECHNICAL_TASK_ID)));
                technicalTask.setOverview(resultSet.getString(ConstantColumnName.TECHNICAL_TASK_OVERVIEW));

                Timestamp timestamp = resultSet.getTimestamp(ConstantColumnName.TECHNICAL_TASK_DEADLINE);
                java.sql.Date deadline = new Date(timestamp.getTime());
                technicalTask.setDeadline(deadline);
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
                technicalTask.setRequirements(findAllByTechnicalTask(technicalTask));
                requirement.setTechnicalTask(technicalTask);

            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return requirement;
    }

    public List<EmployeeRequirement> findAllByTechnicalTask(TechnicalTask technicalTask) throws DaoException {
        List<EmployeeRequirement> requirements = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_BY_TECHNICAL_TASK_ID)) {
            statement.setString(1, String.valueOf(technicalTask.getId()));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                EmployeeRequirement requirement = new EmployeeRequirement();
                requirement.setId(Long.valueOf(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_ID)));
                requirement.setExperience(Integer.valueOf(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_EXPERIENCE)));
                requirement.setSalary(Integer.valueOf(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_SALARY)));
                requirement.setQualification(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_QUALIFICATION));
                requirement.setPrimarySkill(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_PRIMARY_SKILL));
                requirement.setComment(resultSet.getString(ConstantColumnName.EMPLOYEE_REQUIREMENT_COMMENT));
                requirement.setTechnicalTask(technicalTask);
                requirements.add(requirement);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return requirements;
    }

    public EmployeeRequirement updateEmployeeRequirement(EmployeeRequirement requirement) throws DaoException {
        EmployeeRequirement resultRequirement = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_EMPLOYEE_REQUIREMENT)) {
            statement.setString(1, String.valueOf(requirement.getExperience()));
            statement.setString(2, String.valueOf(requirement.getSalary()));
            statement.setString(3, requirement.getQualification());
            statement.setString(4, requirement.getPrimarySkill());
            statement.setString(5, requirement.getComment());
            statement.setString(6, String.valueOf(requirement.getTechnicalTask().getId()));
            statement.setString(7, String.valueOf(requirement.getId()));
            int result = statement.executeUpdate();
            if (result == 1) {
                resultRequirement = requirement;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return resultRequirement;
    }

    public boolean removeUserDetailById(Long id) throws DaoException {
        boolean isRemoved = false;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_EMPLOYEE_REQUIREMENT)) {
            statement.setString(1, String.valueOf(id));
            isRemoved = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return isRemoved;
    }

}

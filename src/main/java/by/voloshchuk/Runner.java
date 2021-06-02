package by.voloshchuk;

import by.voloshchuk.dao.EmployeeRequirementDao;
import by.voloshchuk.dao.impl.*;
import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.*;
import by.voloshchuk.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException, DaoException {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(16L);
//        userDetail.setFirstName("hhh");
//        userDetail.setLastName("hhh");
//        userDetail.setCompany("hhh");
//        userDetail.setPosition("hhh");
//        userDetail.setExperience(8);
//        userDetail.setSalary(12);
//        userDetail.setStatus("hhh");
//
        User user = new User();
        user.setId(1L);
        user.setLogin("AAAAAA");
        user.setPassword("hhh");
        user.setRole("developer");
        user.setUserDetail(userDetail);
//
//        UserDaoImpl userDetailDao = new UserDaoImpl(new UserDetailDaoImpl());
//        System.out.println(userDetailDao.removeUserById(12L));

        EmployeeRequirement requirement = new EmployeeRequirement();
        requirement.setId(12L);
        requirement.setQualification("Software Developer");
        requirement.setComment("");
        requirement.setPrimarySkill("sfs");

        requirement.setExperience(3);
        requirement.setSalary(100);

        TechnicalTask technicalTask = new TechnicalTask();
        requirement.setTechnicalTask(technicalTask);
        technicalTask.setId(7L);
        technicalTask.setCustomer(user);
        java.util.Date incomingValue2 = new java.util.Date(System.currentTimeMillis());
        java.sql.Date databaseValue2 = new java.sql.Date(incomingValue2.getTime());
        technicalTask.setDeadline(databaseValue2);
        technicalTask.setOverview("AAAA");
        List<EmployeeRequirement> list = new ArrayList<>();
        list.add(requirement);
        technicalTask.setRequirements(list);
        technicalTask.setWorkersAmount(1);

        TechnicalTaskDaoImpl technicalTaskDao = new TechnicalTaskDaoImpl();
//        System.out.println(technicalTaskDao.addTechnicalTask(technicalTask));
//        System.out.println(technicalTaskDao.findTechnicalTaskById(7L));
//        System.out.println(technicalTaskDao.updateTechnicalTask(technicalTask));
        System.out.println(technicalTaskDao.removeTechnicalTask(7L));

//        EmployeeRequirementDaoImpl employeeRequirementDao = new EmployeeRequirementDaoImpl();
//        System.out.println(employeeRequirementDao.addEmployeeRequirement(requirement));
//        System.out.println(employeeRequirementDao.findEmployeeRequirementById(12L));
//        System.out.println(employeeRequirementDao.updateEmployeeRequirement(requirement));
//        System.out.println(employeeRequirementDao.removeUserDetailById(12L));

//        Project project = new Project();
//        project.setId(1L);
//        project.setPayment(100);
//        java.util.Date incomingValue = new java.util.Date(System.currentTimeMillis());
//        java.sql.Date databaseValue = new java.sql.Date(incomingValue.getTime());
//        project.setStartDate(databaseValue);
//        project.setTechnicalTask(technicalTask);
//        project.setStatus("in progress");
//
//        ProjectDaoImpl projectDao = new ProjectDaoImpl();
//        System.out.println(projectDao.addProject(project));
//        System.out.println(projectDao.findProjectById(6L).getStartDate());
//        System.out.println(projectDao.updateProject(project));
//        System.out.println(projectDao.removeProject(6L));

//        Task task = new Task();
//        task.setId(11L);
//        task.setName("");
//        task.setDetails("hjvjhvgvlyh");
//        task.setHours(1);
//        task.setStatus("done");
//        task.setProject(project);
//        task.setDeveloper(user);
//
//        TaskDaoImpl taskDao = new TaskDaoImpl();
//        System.out.println(taskDao.addTask(task));
//        System.out.println(taskDao.findTaskById(6L));
//        System.out.println(taskDao.updateTask(task));
//        System.out.println(taskDao.removeTask(11L));

        CustomConnectionPool pool = CustomConnectionPool.getInstance();
        pool.destroyPool();
    }
}

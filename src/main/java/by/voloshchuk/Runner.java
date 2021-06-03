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

        ///////////////////////////////////////////////
        ////////////     USER_DETAILS      ////////////
        ///////////////////////////////////////////////

        UserDetail userDetail = new UserDetail();
        userDetail.setId(12L);
        userDetail.setFirstName("hhh");
        userDetail.setLastName("hhh");
        userDetail.setCompany("hhh");
        userDetail.setPosition("hhh");
        userDetail.setExperience(8);
        userDetail.setSalary(12);
        userDetail.setStatus("hhh");
//        UserDetailDaoImpl userDetailDao = new UserDetailDaoImpl();
//        System.out.println(userDetailDao.addUserDetail(userDetail));
//        System.out.println(userDetailDao.findUserDetailById(7L));
//        System.out.println(userDetailDao.updateUserDetail(userDetail));
//        System.out.println(userDetailDao.removeUserDetailById(7L));

        ///////////////////////////////////////////
        //////////////     USER      //////////////
        ///////////////////////////////////////////

        User user = new User();
        user.setId(1L);
        user.setLogin("AAAAAA");
        user.setPassword("hhh");
        user.setRole("developer");
        user.setUserDetail(userDetail);
//        UserDaoImpl userDaoImpl = new UserDaoImpl();
//        System.out.println(userDaoImpl.addUser(user));
//        System.out.println(userDaoImpl.findUserById(7L));
//        System.out.println(userDaoImpl.updateUser(user));
//        System.out.println(userDaoImpl.removeUserById(12L));

        /////////////////////////////////////////////////////////////////
        ///////////////     EMPLOYEE_REQUIREMENTS     ///////////////////
        /////////////////////////////////////////////////////////////////

        EmployeeRequirement requirement = new EmployeeRequirement();
        requirement.setId(12L);
//        requirement.setQualification("Software Developer");
//        requirement.setComment("");
//        requirement.setPrimarySkill("sfs");
//
//        requirement.setExperience(3);
//        requirement.setSalary(100);

        /////////////////////////////////////////////////////////////////
        ///////////////     TECHNICAL_TASK     //////////////////////////
        /////////////////////////////////////////////////////////////////

        TechnicalTask technicalTask = new TechnicalTask();
        requirement.setTechnicalTask(technicalTask);
        technicalTask.setId(1L);
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
        System.out.println(technicalTaskDao.findTechnicalTaskById(1L));
//        System.out.println(technicalTaskDao.updateTechnicalTask(technicalTask));
//        System.out.println(technicalTaskDao.removeTechnicalTask(7L));

//        EmployeeRequirementDaoImpl employeeRequirementDao = new EmployeeRequirementDaoImpl();
//        System.out.println(employeeRequirementDao.addEmployeeRequirement(requirement));
//        System.out.println(employeeRequirementDao.findAllByTechnicalTask(technicalTask));
//        System.out.println(employeeRequirementDao.findEmployeeRequirementById(1L));
//        System.out.println(employeeRequirementDao.updateEmployeeRequirement(requirement));
//        System.out.println(employeeRequirementDao.removeUserDetailById(12L));

        ///////////////////////////////////////////////////
        ///////////////     PROJECT     ///////////////////
        ///////////////////////////////////////////////////

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

        ////////////////////////////////////////////////
        ///////////////     TASK     ///////////////////
        ////////////////////////////////////////////////

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

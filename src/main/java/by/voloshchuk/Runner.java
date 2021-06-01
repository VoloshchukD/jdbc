package by.voloshchuk;

import by.voloshchuk.dao.EmployeeRequirementDao;
import by.voloshchuk.dao.impl.EmployeeRequirementDaoImpl;
import by.voloshchuk.dao.impl.ProjectDaoImpl;
import by.voloshchuk.dao.impl.UserDaoImpl;
import by.voloshchuk.dao.impl.UserDetailDaoImpl;
import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.*;
import by.voloshchuk.exception.DaoException;

import java.sql.*;

public class Runner {
    public static void main(String[] args) throws SQLException, DaoException {
//        UserDetail userDetail = new UserDetail();
//        userDetail.setId(16L);
//        userDetail.setFirstName("hhh");
//        userDetail.setLastName("hhh");
//        userDetail.setCompany("hhh");
//        userDetail.setPosition("hhh");
//        userDetail.setExperience(8);
//        userDetail.setSalary(12);
//        userDetail.setStatus("hhh");
//
//        User user = new User();
//        user.setId(12L);
//        user.setLogin("AAAAAA");
//        user.setPassword("hhh");
//        user.setRole("developer");
//        user.setUserDetail(userDetail);
//
//        UserDaoImpl userDetailDao = new UserDaoImpl(new UserDetailDaoImpl());
//        System.out.println(userDetailDao.removeUserById(12L));

        TechnicalTask technicalTask = new TechnicalTask();
        technicalTask.setId(1L);
//        technicalTask.setCustomer();
//        technicalTask.setDeadline();
//        technicalTask.setOverview();
//        technicalTask.setRequirements();
//        technicalTask.setRequirements();
//        technicalTask.setWorkersAmount(1);


//        EmployeeRequirement requirement = new EmployeeRequirement();
//        requirement.setId(12L);
//        requirement.setQualification("Software Developer");
//        requirement.setComment("");
//        requirement.setPrimarySkill("sfs");
//        requirement.setTechnicalTask(technicalTask);
//        requirement.setExperience(3);
//        requirement.setSalary(100);
//
//        EmployeeRequirementDaoImpl employeeRequirementDao = new EmployeeRequirementDaoImpl();
////        System.out.println(employeeRequirementDao.addEmployeeRequirement(requirement));
////        System.out.println(employeeRequirementDao.findEmployeeRequirementById(12L));
//        System.out.println(employeeRequirementDao.updateEmployeeRequirement(requirement));
//        System.out.println(employeeRequirementDao.removeUserDetailById(12L));

        Project project = new Project();
        project.setId(6L);
        project.setPayment(100);
        java.util.Date incomingValue = new java.util.Date(System.currentTimeMillis());
        java.sql.Date databaseValue = new java.sql.Date(incomingValue.getTime());
        project.setStartDate(databaseValue);
        project.setTechnicalTask(technicalTask);
        project.setStatus("in progress");

        ProjectDaoImpl projectDao = new ProjectDaoImpl();
//        System.out.println(projectDao.addProject(project));
//        System.out.println(projectDao.findProjectById(6L).getStartDate());
//        System.out.println(projectDao.updateProject(project));
        System.out.println(projectDao.removeProject(6L));


        CustomConnectionPool pool = CustomConnectionPool.getInstance();
        pool.destroyPool();
    }
}

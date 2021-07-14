package by.voloshchuk;

import by.voloshchuk.dao.BillDao;
import  by.voloshchuk.dao.impl.*;
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
        userDetail.setId(11L);
        userDetail.setFirstName("hhh");
        userDetail.setLastName("hhh");
        userDetail.setCompany("hhh");
        userDetail.setPosition("hhh");
        userDetail.setExperience(8);
        userDetail.setSalary(12);
        userDetail.setStatus("hhh");
//        UserDetailDaoImpl userDetailDao = new UserDetailDaoImpl();
//        System.out.println(userDetailDao.addUserDetail(userDetail));
//        System.out.println(userDetailDao.findUserDetailById(12L));
//        System.out.println(userDetailDao.updateUserDetail(userDetail));
//        System.out.println(userDetailDao.removeUserDetailById(12L));

        /////////////////////////////////////////////////////////////////
        ///////////////     EMPLOYEE_REQUIREMENTS     ///////////////////
        /////////////////////////////////////////////////////////////////

        EmployeeRequirement requirement = new EmployeeRequirement();
        requirement.setId(11L);
        requirement.setQualification("Software Developer");
        requirement.setComment("");
        requirement.setPrimarySkill("sfs");
        requirement.setExperience(3);
        requirement.setSalary(100);

        ///////////////////////////////////////////
        //////////////     USER      //////////////
        ///////////////////////////////////////////

        User user = new User();
        user.setId(11L);
        user.setEmail("AAAAAA");
        user.setPassword("hhh");
        user.setRole("developer");
        user.setUserDetail(userDetail);
//        UserDaoImpl userDaoImpl = new UserDaoImpl();
//        System.out.println(userDaoImpl.addUser(user));
//        System.out.println(userDaoImpl.findUserById(14L));
//        System.out.println(userDaoImpl.updateUser(user));
//        System.out.println(userDaoImpl.findUserByEmail("AAAAAA"));
//        System.out.println(userDaoImpl.findAllByEmployeeRequirement(requirement));
//
//        System.out.println(userDaoImpl.addUserToProject(15L, 14L));
//        System.out.println(userDaoImpl.removeUserFromProject(15L, 14L));

//        System.out.println(userDaoImpl.removeUserById(14L));

        /////////////////////////////////////////////////////////////////
        ///////////////     TECHNICAL_TASK     //////////////////////////
        /////////////////////////////////////////////////////////////////

        TechnicalTask technicalTask = new TechnicalTask();
        requirement.setTechnicalTask(technicalTask);
        technicalTask.setId(6L);
        technicalTask.setCustomer(user);
        java.util.Date incomingValue2 = new java.util.Date(System.currentTimeMillis());
        java.sql.Date databaseValue2 = new java.sql.Date(incomingValue2.getTime());
        technicalTask.setDeadline(databaseValue2);
        technicalTask.setOverview("AAAA");
        List<EmployeeRequirement> list = new ArrayList<>();
        list.add(requirement);
        technicalTask.setRequirements(list);
        technicalTask.setWorkersAmount(1);

//        TechnicalTaskDaoImpl technicalTaskDao = new TechnicalTaskDaoImpl();
//        System.out.println(technicalTaskDao.addTechnicalTask(technicalTask));
//        System.out.println(technicalTaskDao.findTechnicalTaskById(7L));
//        System.out.println(technicalTaskDao.updateTechnicalTask(technicalTask));
//        System.out.println(technicalTaskDao.findTechnicalTasksByCustomerId(11L));
//        System.out.println(technicalTaskDao.findTechnicalTasksByStatus("WAIT_PROJECT"));
//        System.out.println(technicalTaskDao.removeTechnicalTask(7L));

//        EmployeeRequirementDaoImpl employeeRequirementDao = new EmployeeRequirementDaoImpl();
//        System.out.println(employeeRequirementDao.addEmployeeRequirement(requirement));
//        System.out.println(employeeRequirementDao.findAllByTechnicalTaskId(2L));
//        System.out.println(employeeRequirementDao.updateEmployeeRequirement(requirement));
//        System.out.println(employeeRequirementDao.removeUserDetailById(11L));

        ///////////////////////////////////////////////////
        ///////////////     PROJECT     ///////////////////
        ///////////////////////////////////////////////////

        Project project = new Project();
        project.setId(1L);
        project.setName("projj");
        project.setDescription("description");
        java.util.Date incomingValue = new java.util.Date(System.currentTimeMillis());
        java.sql.Date databaseValue = new java.sql.Date(incomingValue.getTime());
        project.setStartDate(databaseValue);
        project.setTechnicalTask(technicalTask);
        project.setState("in progress");

//        ProjectDaoImpl projectDao = new ProjectDaoImpl();
//        System.out.println(projectDao.addProject(project));
//        System.out.println(projectDao.findProjectById(63L));
//        System.out.println(projectDao.updateProject(project));
//        System.out.println(projectDao.findProjectsByUserIdAndState(11L, "finished"));
//        System.out.println(projectDao.removeProject(63L));

        /////////////////////////////////////////
        ////////////     BILLS      ////////////
        ////////////////////////////////////////

        Bill bill = new Bill();
        bill.setId(5L);
        bill.setProjectId(1L);
        bill.setStatus("paid");
        bill.setInformation("info");
        bill.setAmountDue(999);

//        BillDao billDao = new BillDaoImpl();
//        System.out.println(billDao.addBill(bill));
//        System.out.println(billDao.findBillById(5L));
//        System.out.println(billDao.findBillsByUserId(9L));
//        System.out.println(billDao.updateBill(bill));
//        System.out.println(billDao.removeBill(5L));

        ////////////////////////////////////////////////
        ///////////////     TASK     ///////////////////
        ////////////////////////////////////////////////

        Task task = new Task();
        task.setId(11L);
        task.setName("nnnammme");
        task.setDetails("hjvjhvgvlyh");
        task.setHours(1);
        task.setStatus("done");
        task.setProject(project);
        task.setDeveloper(user);

        TaskDaoImpl taskDao = new TaskDaoImpl();
//        System.out.println(taskDao.addTask(task));
//        System.out.println(taskDao.findTaskById(11L));
//        System.out.println(taskDao.updateTask(task));
//        System.out.println(taskDao.findTaskByProjectId(1L));
//        System.out.println(taskDao.findTaskByUserIdAndProjectId(1L, 1L));
//        System.out.println(taskDao.removeTask(11L));

    }
}

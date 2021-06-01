package by.voloshchuk;

import by.voloshchuk.dao.EmployeeRequirementDao;
import by.voloshchuk.dao.impl.EmployeeRequirementDaoImpl;
import by.voloshchuk.dao.impl.UserDaoImpl;
import by.voloshchuk.dao.impl.UserDetailDaoImpl;
import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.EmployeeRequirement;
import by.voloshchuk.entity.TechnicalTask;
import by.voloshchuk.entity.User;
import by.voloshchuk.entity.UserDetail;
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


        EmployeeRequirement requirement = new EmployeeRequirement();
        requirement.setId(12L);
        requirement.setQualification("Software Developer");
        requirement.setComment("");
        requirement.setPrimarySkill("sfs");
        requirement.setTechnicalTask(technicalTask);
        requirement.setExperience(3);
        requirement.setSalary(100);

        EmployeeRequirementDaoImpl employeeRequirementDao = new EmployeeRequirementDaoImpl();
//        System.out.println(employeeRequirementDao.addEmployeeRequirement(requirement));
//        System.out.println(employeeRequirementDao.findEmployeeRequirementById(12L));
        System.out.println(employeeRequirementDao.updateEmployeeRequirement(requirement));
        System.out.println(employeeRequirementDao.removeUserDetailById(12L));

        CustomConnectionPool pool = CustomConnectionPool.getInstance();
        pool.destroyPool();
    }
}

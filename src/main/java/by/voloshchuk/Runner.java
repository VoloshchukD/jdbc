package by.voloshchuk;

import by.voloshchuk.dao.impl.UserDetailDaoImpl;
import by.voloshchuk.dao.pool.CustomConnectionPool;
import by.voloshchuk.entity.UserDetail;
import by.voloshchuk.exception.DaoException;

import java.sql.*;

public class Runner {
    public static void main(String[] args) throws SQLException, DaoException {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(15L);
        userDetail.setFirstName("OO");
        userDetail.setLastName("OO");
        userDetail.setCompany("OO");
        userDetail.setPosition("OO");
        userDetail.setExperience(8);
        userDetail.setSalary(12);
        userDetail.setStatus("sdg");


        UserDetailDaoImpl userDetailDao = new UserDetailDaoImpl();
        System.out.println(userDetailDao.removeUserDetailById(15L));




        CustomConnectionPool pool = CustomConnectionPool.getInstance();
        pool.destroyPool();
    }
}

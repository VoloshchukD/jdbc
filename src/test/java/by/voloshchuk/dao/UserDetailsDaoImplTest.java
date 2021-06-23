package by.voloshchuk.dao;

import by.voloshchuk.dao.impl.UserDetailDaoImpl;
import by.voloshchuk.entity.UserDetail;
import by.voloshchuk.exception.DaoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDetailsDaoImplTest {

    private static UserDetailDaoImpl userDetailDao;

    private static UserDetail userDetail;

//    @BeforeClass
    public static void initializeDaoImpl() {
        userDetailDao = new UserDetailDaoImpl();

        userDetail = new UserDetail();
        userDetail.setFirstName("hhh");
        userDetail.setLastName("hhh");
        userDetail.setCompany("hhh");
        userDetail.setPosition("hhh");
        userDetail.setExperience(8);
        userDetail.setSalary(12);
        userDetail.setStatus("hhh");
    }

//    @Test
    public void addUserDetails() {
        boolean result = false;
        try {
            result = userDetailDao.addUserDetail(userDetail);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result);
    }

//    @Test
    public void findUserDetailsById() {
        UserDetail resultUserDetail = null;
        try {
            resultUserDetail = userDetailDao.findUserDetailById(userDetail.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(userDetail.getId(), resultUserDetail.getId());
    }

//    @Test
    public void updateUserDetail() {
        userDetail.setCompany("Google");
        UserDetail resultUserDetail = null;
        try {
            resultUserDetail = userDetailDao.updateUserDetail(userDetail);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(userDetail.getCompany(), resultUserDetail.getCompany());
    }

//    @Test
    public void removeUserDetailById() {
        boolean isRemoved = false;
        try {
            isRemoved = userDetailDao.removeUserDetailById(userDetail.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(isRemoved);
    }

}

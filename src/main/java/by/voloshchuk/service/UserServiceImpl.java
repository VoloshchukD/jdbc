package by.voloshchuk.service;

import by.voloshchuk.dao.UserDao;
import by.voloshchuk.dao.UserDetailDao;
import by.voloshchuk.dao.impl.UserDaoImpl;
import by.voloshchuk.dao.impl.UserDetailDaoImpl;
import by.voloshchuk.entity.User;
import by.voloshchuk.exception.DaoException;
import by.voloshchuk.exception.ServiceException;
import org.mindrot.jbcrypt.BCrypt;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    private UserDetailDao userDetailDao = new UserDetailDaoImpl();

    public void addUser(User user) throws ServiceException {
        try {
            userDetailDao.addUserDetail(user.getUserDetail());
            String password = user.getPassword();
            String hash = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setPassword(hash);
            userDao.addUser(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    //        System.out.println(BCrypt.checkpw(password, hash));

    public void resetPassword(User user) {
//        Password
        user.getPassword();
        String password = "abcd";
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hash);
        System.out.println(BCrypt.checkpw(password, hash));
    }

}

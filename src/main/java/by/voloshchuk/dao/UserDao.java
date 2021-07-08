package by.voloshchuk.dao;

import by.voloshchuk.entity.User;
import by.voloshchuk.exception.DaoException;

public interface UserDao {

    boolean addUser(User user) throws DaoException;

    User findUserByEmail(String email) throws DaoException;

}

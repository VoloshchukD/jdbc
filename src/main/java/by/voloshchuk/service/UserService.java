package by.voloshchuk.service;

import by.voloshchuk.entity.User;
import by.voloshchuk.exception.ServiceException;

public interface UserService {

    void addUser(User user) throws ServiceException;

    User checkUser(String email, String password) throws ServiceException;

    void resetPassword(User user);

}

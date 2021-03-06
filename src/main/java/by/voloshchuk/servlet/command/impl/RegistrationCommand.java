package by.voloshchuk.servlet.command.impl;

import by.voloshchuk.entity.User;
import by.voloshchuk.entity.UserDetail;
import by.voloshchuk.exception.ServiceException;
import by.voloshchuk.service.UserService;
import by.voloshchuk.service.impl.UserServiceImpl;
import by.voloshchuk.servlet.command.Command;
import by.voloshchuk.servlet.command.CommandPath;
import by.voloshchuk.servlet.command.RequestParameter;
import by.voloshchuk.servlet.command.SessionAttribute;
import by.voloshchuk.util.RegexProperty;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private UserService userService = new UserServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            User user = createUser(request);
            try {
                if (userService.addUser(user)) {
                    request.getSession().setAttribute(SessionAttribute.USER_ID, user.getId());
                    request.getSession().setAttribute(SessionAttribute.ROLE, user.getRole());
                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            response.sendRedirect(CommandPath.MAIN);
    }

    private User createUser(HttpServletRequest request) {
        User user = new User();
        user.setEmail(request.getParameter(RequestParameter.EMAIL));
        user.setPassword(request.getParameter(RequestParameter.PASSWORD));
        user.setRole(request.getParameter(RequestParameter.ROLE));
        user.setUserDetail(createUserDetails(request));
        return user;
    }

    private UserDetail createUserDetails(HttpServletRequest request) {
        UserDetail userDetail = new UserDetail();
        userDetail.setFirstName(request.getParameter(RequestParameter.FIRST_NAME));
        userDetail.setLastName(request.getParameter(RequestParameter.LAST_NAME));
        userDetail.setCompany(request.getParameter(RequestParameter.COMPANY));
        userDetail.setPosition(request.getParameter(RequestParameter.POSITION));
        userDetail.setExperience(Integer.parseInt(request.getParameter(RequestParameter.EXPERIENCE)));
        userDetail.setSalary(Integer.parseInt(request.getParameter(RequestParameter.SALARY)));
        userDetail.setPrimarySkill(request.getParameter(RequestParameter.PRIMARY_SKILL));
        userDetail.setSkillsDescription(request.getParameter(RequestParameter.SKILLS_DESCRIPTION));
        userDetail.setStatus(request.getParameter(RequestParameter.STATUS));
        return userDetail;
    }

}

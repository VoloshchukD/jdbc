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
        if (request.getMethod().equals("POST")) {
            User user = createUser(request);
            try {
                if (userService.addUser(user)) {
                    request.getSession().setAttribute(SessionAttribute.USER_ID, user.getId());
                    request.getSession().setAttribute(SessionAttribute.ROLE, user.getRole());
                    System.out.println("/////// " + request.getSession().getAttribute("userId") + " " + request.getSession().getAttribute("role"));
                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            response.sendRedirect(CommandPath.MAIN);
        } else if (request.getMethod().equals("GET")) {
            request.setAttribute(SessionAttribute.EMAIL_REGEX, RegexProperty.PROPERTY_EMAIL_REGEX);
            request.setAttribute(SessionAttribute.PASSWORD_REGEX, RegexProperty.PROPERTY_PASSWORD_REGEX);
            request.setAttribute(SessionAttribute.FIRST_REGEX, RegexProperty.PROPERTY_FIRST_REGEX);
            request.setAttribute(SessionAttribute.LAST_REGEX, RegexProperty.PROPERTY_LAST_REGEX);
            request.setAttribute(SessionAttribute.COMPANY_REGEX, RegexProperty.PROPERTY_COMPANY_REGEX);
            request.setAttribute(SessionAttribute.POSITION_REGEX, RegexProperty.PROPERTY_POSITION_REGEX);
            request.setAttribute(SessionAttribute.EXPERIENCE_REGEX, RegexProperty.PROPERTY_EXPERIENCE_REGEX);
            request.setAttribute(SessionAttribute.SALARY_REGEX, RegexProperty.PROPERTY_SALARY_REGEX);
            request.setAttribute(SessionAttribute.PRIMARY_REGEX, RegexProperty.PROPERTY_PRIMARY_REGEX);
            request.setAttribute(SessionAttribute.SKILLS_REGEX, RegexProperty.PROPERTY_SKILLS_REGEX);
            System.out.println("regex " + request.getAttribute(SessionAttribute.EMAIL_REGEX));
            request.getRequestDispatcher("/jsp/reg.jsp").forward(request, response);
        }
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

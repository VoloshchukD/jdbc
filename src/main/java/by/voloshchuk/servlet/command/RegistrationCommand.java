package by.voloshchuk.servlet.command;

import by.voloshchuk.entity.User;
import by.voloshchuk.entity.UserDetail;
import by.voloshchuk.exception.ServiceException;
import by.voloshchuk.service.UserService;
import by.voloshchuk.service.UserServiceImpl;
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
                    request.getSession().setAttribute("role", user.getRole());
                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            response.sendRedirect("http://localhost:8080/controller?command=main");
        } else if (request.getMethod().equals("GET")) {
            request.getRequestDispatcher("/jsp/reg.jsp").forward(request, response);
        }
    }

    private User createUser(HttpServletRequest request) {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));
        user.setUserDetail(createUserDetails(request));
        return user;
    }

    private UserDetail createUserDetails(HttpServletRequest request) {
        UserDetail userDetail = new UserDetail();
        userDetail.setFirstName(request.getParameter("firstName"));
        userDetail.setLastName(request.getParameter("lastName"));
        userDetail.setCompany(request.getParameter("company"));
        userDetail.setPosition(request.getParameter("position"));
        userDetail.setExperience(Integer.parseInt(request.getParameter("experience")));
        userDetail.setSalary(Integer.parseInt(request.getParameter("salary")));
        userDetail.setPrimarySkill(request.getParameter("primarySkill"));
        userDetail.setSkillsDescription(request.getParameter("skillsDescription"));
        userDetail.setStatus(request.getParameter("status"));
        return userDetail;
    }

}

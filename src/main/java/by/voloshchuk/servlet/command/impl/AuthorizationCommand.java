package by.voloshchuk.servlet.command.impl;

import by.voloshchuk.entity.User;
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

public class AuthorizationCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private UserService userService = new UserServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String email = request.getParameter(RequestParameter.EMAIL);
            String password = request.getParameter(RequestParameter.PASSWORD);
            try {
                User currentUser = userService.checkUser(email, password);
                if (currentUser != null) {
                    request.getSession().setAttribute(SessionAttribute.USER_ID, currentUser.getId());
                    request.getSession().setAttribute(SessionAttribute.ROLE, currentUser.getRole());
                    System.out.println("/////// " + request.getSession().getAttribute(SessionAttribute.USER_ID) + " " + request.getSession().getAttribute("role"));

                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            response.sendRedirect(CommandPath.MAIN);
    }

}

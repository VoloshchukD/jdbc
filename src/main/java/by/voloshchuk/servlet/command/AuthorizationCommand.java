package by.voloshchuk.servlet.command;

import by.voloshchuk.entity.User;
import by.voloshchuk.exception.ServiceException;
import by.voloshchuk.service.UserService;
import by.voloshchuk.service.impl.UserServiceImpl;
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

        if (request.getMethod().equals("POST")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            try {
                User currentUser = userService.checkUser(email, password);
                if (currentUser != null) {
                    request.getSession().setAttribute("userId", currentUser.getId());
                    request.getSession().setAttribute("role", currentUser.getRole());
                    System.out.println("/////// " + request.getSession().getAttribute("userId") + " " + request.getSession().getAttribute("role"));

                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
            response.sendRedirect("http://localhost:8080/controller?command=main");
        } else if (request.getMethod().equals("GET")) {
            request.getRequestDispatcher("/jsp/auth.jsp").forward(request, response);
        }
    }

}

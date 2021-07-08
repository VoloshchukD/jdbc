package by.voloshchuk.servlet.command;

import by.voloshchuk.entity.User;
import by.voloshchuk.exception.ServiceException;
import by.voloshchuk.service.UserService;
import by.voloshchuk.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationCommand implements Command {

    private UserService userService = new UserServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (request.getMethod().equals("POST")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            try {
                User currentUser = userService.checkUser(email, password);
                if (currentUser != null) {
                    request.getSession().setAttribute("role", currentUser.getRole());
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            response.sendRedirect("http://localhost:8080/controller?command=main");
        } else if (request.getMethod().equals("GET")) {
            request.getRequestDispatcher("/jsp/auth.jsp").forward(request, response);
        }
    }

}

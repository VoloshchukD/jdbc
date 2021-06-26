package by.voloshchuk.servlet.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class RegistrationCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getMethod().equals("POST")) {

            response.sendRedirect("http://localhost:8080/controller?command=main");
        } else if (request.getMethod().equals("GET")) {
            request.getRequestDispatcher("/jsp/reg.jsp").forward(request, response);
        }
    }

}

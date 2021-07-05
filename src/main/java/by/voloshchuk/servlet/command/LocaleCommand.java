package by.voloshchuk.servlet.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocaleCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("loc");
        request.getSession(true).setAttribute("local", request.getParameter("local"));
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }

}

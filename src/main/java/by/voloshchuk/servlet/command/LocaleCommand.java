package by.voloshchuk.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocaleCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession(true).setAttribute("local", request.getParameter("local"));
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }

}

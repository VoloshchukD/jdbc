package by.voloshchuk.servlet;


import by.voloshchuk.JSPSetBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class HelloServlet extends HttpServlet {

    private static final CommandProvider provider = CommandProvider.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println(req.getRequestURI());
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("req param name");
//        Command command = provider.getCommand(name);
//        command.execute(req, resp);
//        Base64.Encoder


//        String first_name = req.getParameter("email");
//        System.out.println("post " + first_name + " " + req.getRequestURI());

        req.getSession(true).setAttribute("local", req.getParameter("local"));
//        req.getRequestDispatcher("index.jsp").forward(req,   resp);
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Set<String> set = new HashSet<String>();
        set.add("one");
        set.add("two");
        set.add("three");
        JSPSetBean jsp = new JSPSetBean(set);

        request.setAttribute("userbean", jsp);

        request.getRequestDispatcher("jsp/main.jsp").forward(request,   response);
    }


}

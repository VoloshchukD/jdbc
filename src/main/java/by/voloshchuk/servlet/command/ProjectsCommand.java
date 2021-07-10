package by.voloshchuk.servlet.command;

import by.voloshchuk.entity.Project;
import by.voloshchuk.exception.ServiceException;
import by.voloshchuk.service.ProjectService;
import by.voloshchuk.service.impl.ProjectServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private ProjectService projectService = new ProjectServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int projectsPerPage = Integer.parseInt(request.getParameter("projectsPerPage"));
        Long userId = (Long) request.getSession().getAttribute("userId");
        List<Project> projects = null;
        System.out.println("proj");
        try {
            projects = projectService.findProjectsByUserId(userId);
            System.out.println("projects" + projects);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e.getMessage());
        }

        List<Project> pageProjects = new ArrayList<>();
        int start = (currentPage - 1) * projectsPerPage;
        for (int i = start; i < start + projectsPerPage; i++) {
            if (i == projects.size()) {
                break;
            }
            pageProjects.add(projects.get(i));
        }

        request.setAttribute("projects", pageProjects);

        int pagesNumber = projects.size() / projectsPerPage;
        if (projects.size() % projectsPerPage != 0) {
            pagesNumber++;
        }
        System.out.println("allPagesNumber " + pagesNumber);
        request.setAttribute("allPagesNumber", pagesNumber);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("projectsPerPage", projectsPerPage);

        request.getRequestDispatcher("/jsp/projects.jsp").forward(request, response);
    }

}

package by.voloshchuk.servlet.command;

import by.voloshchuk.entity.Project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsCommand implements Command {

    static List<Project> projects;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int projectsPerPage = Integer.parseInt(request.getParameter("projectsPerPage"));

        if (projects == null) {
            projects = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                Project project = new Project();
                project.setId((long) i);
                project.setPayment(i * 100);
                projects.add(project);
            }
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

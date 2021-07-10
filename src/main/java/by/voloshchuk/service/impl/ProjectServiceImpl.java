package by.voloshchuk.service.impl;

import by.voloshchuk.dao.ProjectDao;
import by.voloshchuk.dao.impl.ProjectDaoImpl;
import by.voloshchuk.entity.Project;
import by.voloshchuk.exception.DaoException;
import by.voloshchuk.exception.ServiceException;
import by.voloshchuk.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao = new ProjectDaoImpl();

    @Override
    public List<Project> findProjectsByUserId(Long useId) throws ServiceException {
        List<Project> projects = null;
        try {
            projects = projectDao.findProjectsByUserId(useId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return projects;
    }

}

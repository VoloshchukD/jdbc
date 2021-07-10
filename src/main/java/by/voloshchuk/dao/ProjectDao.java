package by.voloshchuk.dao;

import by.voloshchuk.entity.Project;
import by.voloshchuk.exception.DaoException;

import java.util.List;

public interface ProjectDao {

    List<Project> findProjectsByUserId(Long userId) throws DaoException;

}

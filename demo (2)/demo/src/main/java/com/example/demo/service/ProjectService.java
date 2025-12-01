package com.example.demo.service;

import com.example.demo.persistence.model.Project;
import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    List<Project> getProjectsByName(String word);

    Project createProject(Project project);

    Project updateProject(Integer id, Project project);

    void deleteProject(Integer id);
}

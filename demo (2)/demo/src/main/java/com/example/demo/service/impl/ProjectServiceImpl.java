package com.example.demo.service.impl;

import com.example.demo.persistence.model.Project;
import com.example.demo.persistence.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getProjectsByName(String word) {
        return projectRepository.findByNameContainingIgnoreCase(word);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Integer id, Project project) {
        Project existing = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        existing.setName(project.getName());
        existing.setDescription(project.getDescription());
        existing.setStartDate(project.getStartDate());
        existing.setEndDate(project.getEndDate());
        existing.setDemoUrl(project.getDemoUrl());
        existing.setPicture(project.getPicture());
        existing.setStatus(project.getStatus());
        existing.setTechnologies(project.getTechnologies());
        existing.setDevelopers(project.getDevelopers());

        return projectRepository.save(existing);
    }

    @Override
    public void deleteProject(Integer id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found");
        }
        projectRepository.deleteById(id);
    }
}

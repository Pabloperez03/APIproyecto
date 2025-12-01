package com.example.demo.controller;

import com.example.demo.persistence.model.Project;
import com.example.demo.service.ProjectService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // GET /projects
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    // GET /projects/{word}
    @GetMapping("/projects/{word}")
    public ResponseEntity<List<Project>> getProjectsByWord(@PathVariable String word) {
        List<Project> projects = projectService.getProjectsByName(word);
        return ResponseEntity.ok(projects);
    }

    // POST /projects
    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project created = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT /projects/{id}
    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(
            @PathVariable Integer id,
            @RequestBody Project project) {

        try {
            Project updated = projectService.updateProject(id, project);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /projects/{id}
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {

        try {
            projectService.deleteProject(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

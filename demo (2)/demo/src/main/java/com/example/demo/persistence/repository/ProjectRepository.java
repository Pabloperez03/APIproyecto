package com.example.demo.persistence.repository;

import com.example.demo.persistence.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByNameContainingIgnoreCase(String word);
}

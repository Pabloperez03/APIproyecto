package com.example.demo.persistence.repository;

import com.example.demo.persistence.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
}

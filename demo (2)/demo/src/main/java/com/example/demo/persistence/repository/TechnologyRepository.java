package com.example.demo.persistence.repository;

import com.example.demo.persistence.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}

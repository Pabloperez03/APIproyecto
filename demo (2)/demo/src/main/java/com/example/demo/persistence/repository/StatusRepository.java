package com.example.demo.persistence.repository;

import com.example.demo.persistence.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}

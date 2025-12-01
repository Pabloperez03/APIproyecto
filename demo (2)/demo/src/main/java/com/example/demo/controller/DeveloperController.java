package com.example.demo.controller;

import com.example.demo.persistence.model.Developer;
import com.example.demo.service.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    // POST /developers
    @PostMapping("/developers")
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer) {
        Developer created = developerService.createDeveloper(developer);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // DELETE /developers/{id}
    @DeleteMapping("/developers/{id}")
    public ResponseEntity<Void> deleteDeveloper(@PathVariable Integer id) {
        try {
            developerService.deleteDeveloper(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

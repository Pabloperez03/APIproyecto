package com.example.demo.controller;

import com.example.demo.persistence.model.Technology;
import com.example.demo.service.TechnologyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    // POST /technologies
    @PostMapping("/technologies")
    public ResponseEntity<Technology> createTechnology(@RequestBody Technology technology) {
        Technology created = technologyService.createTechnology(technology);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // DELETE /technologies/{id}
    @DeleteMapping("/technologies/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Integer id) {
        try {
            technologyService.deleteTechnology(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

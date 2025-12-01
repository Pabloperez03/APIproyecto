package com.example.demo.service.impl;

import com.example.demo.persistence.model.Technology;
import com.example.demo.persistence.repository.TechnologyRepository;
import com.example.demo.service.TechnologyService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    @Override
    public Technology createTechnology(Technology technology) {
        return technologyRepository.save(technology);
    }

    @Override
    public void deleteTechnology(Integer id) {
        if (!technologyRepository.existsById(id)) {
            throw new RuntimeException("Technology not found with id " + id);
        }
        technologyRepository.deleteById(id);
    }
}

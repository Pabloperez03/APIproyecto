package com.example.demo.service.impl;

import com.example.demo.persistence.model.Developer;
import com.example.demo.persistence.repository.DeveloperRepository;
import com.example.demo.service.DeveloperService;
import org.springframework.stereotype.Service;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public void deleteDeveloper(Integer id) {
        if (!developerRepository.existsById(id)) {
            throw new RuntimeException("Developer not found");
        }
        developerRepository.deleteById(id);
    }
}

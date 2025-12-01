package com.example.demo.service;

import com.example.demo.persistence.model.Developer;

public interface DeveloperService {

    Developer createDeveloper(Developer developer);

    void deleteDeveloper(Integer id);
}

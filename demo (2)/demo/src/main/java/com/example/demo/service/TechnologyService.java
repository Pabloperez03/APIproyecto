package com.example.demo.service;

import com.example.demo.persistence.model.Technology;

public interface TechnologyService {

    Technology createTechnology(Technology technology);

    void deleteTechnology(Integer id);
}

package com.example.demo.persistence.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer id;

    @Column(name = "project_name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", nullable = false, length = 150)
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "demo_url", nullable = false, length = 150)
    private String demoUrl;

    @Column(name = "picture", nullable = false, length = 150)
    private String picture;

    @ManyToOne
    @JoinColumn(name = "status_status_id", nullable = false)
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "technologies_used_in_projects",
            joinColumns = @JoinColumn(name = "projects_project_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnologia_tecnologia_id")
    )
    private Set<Technology> technologies = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "developers_worked_on_projects",
            joinColumns = @JoinColumn(name = "projects_project_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_dev_id")
    )
    private Set<Developer> developers = new HashSet<>();

    public Project() {
    }

    // getters y setters (todos)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<Technology> technologies) {
        this.technologies = technologies;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }
}

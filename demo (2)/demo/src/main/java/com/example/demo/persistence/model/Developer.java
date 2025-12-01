package com.example.demo.persistence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private Integer id;

    @Column(name = "devname", nullable = false, length = 20)
    private String name;

    @Column(name = "dev_surname", nullable = false, length = 60)
    private String surname;

    @Column(nullable = false, length = 90)
    private String email;

    @Column(name = "linkedin_url", nullable = false, length = 90)
    private String linkedinUrl;

    @Column(name = "github_url", nullable = false, length = 90)
    private String githubUrl;

    public Developer() {
    }

    // getters y setters
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }
}
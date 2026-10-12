package com.theingimyint.portfolio.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String summary;

    @Column(columnDefinition = "text")
    private String description;

    private String githubUrl;
    private String demoUrl;
    private String imageUrl;

    @Column(nullable = false)
    private boolean featured;

    @Column(nullable = false)
    private int displayOrder;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "project_skill",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    protected Project() {}

    public String getTitle() { return title; }
    public String getSlug() { return slug; }
    public String getSummary() { return summary; }
    public String getDescription() { return description; }
    public String getGithubUrl() { return githubUrl; }
    public String getDemoUrl() { return demoUrl; }
    public String getImageUrl() { return imageUrl; }
    public boolean isFeatured() { return featured; }
    public int getDisplayOrder() { return displayOrder; }
    public Status getStatus() { return status; }
    public Set<Skill> getSkills() { return skills; }
}
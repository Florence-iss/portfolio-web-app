package com.theingimyint.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skill extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    private String category;

    @Column(nullable = false)
    private boolean showOnAbout;

    @Column(nullable = false)
    private int displayOrder;

    protected Skill() {}

    public String getName() { return name; }
    public String getSlug() { return slug; }
    public String getCategory() { return category; }
    public boolean isShowOnAbout() { return showOnAbout; }
    public int getDisplayOrder() { return displayOrder; }
}
package com.theingimyint.portfolio.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String slug) {
        super("Project not found: " + slug);
    }
}
package com.theingimyint.portfolio.service;

import com.theingimyint.portfolio.dto.ProjectDetailDto;
import com.theingimyint.portfolio.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findPublished();
    ProjectDetailDto findBySlug(String slug);
}
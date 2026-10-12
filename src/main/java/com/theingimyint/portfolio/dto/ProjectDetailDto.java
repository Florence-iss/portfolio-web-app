package com.theingimyint.portfolio.dto;

import java.util.List;

public record ProjectDetailDto(
        String title,
        String summary,
        String description,
        String githubUrl,
        String demoUrl,
        List<String> skills
) {}
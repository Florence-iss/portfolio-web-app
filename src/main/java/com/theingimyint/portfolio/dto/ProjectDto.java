package com.theingimyint.portfolio.dto;

import java.util.List;

public record ProjectDto(
        String title,
        String slug,
        String summary,
        List<String> skills
) {}
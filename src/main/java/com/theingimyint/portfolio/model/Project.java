package com.theingimyint.portfolio.model;

import java.util.List;

public record Project(
        String title,
        String summary,
        List<String> skills
) {}
package com.theingimyint.portfolio.Model;

import java.util.List;

public record Project(
        String title,
        String summary,
        List<String> skills
) {}
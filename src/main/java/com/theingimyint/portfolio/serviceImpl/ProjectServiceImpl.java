package com.theingimyint.portfolio.serviceImpl;

import com.theingimyint.portfolio.dto.ProjectDto;
import com.theingimyint.portfolio.model.Project;
import com.theingimyint.portfolio.model.Skill;
import com.theingimyint.portfolio.model.Status;
import com.theingimyint.portfolio.repository.ProjectRepository;
import com.theingimyint.portfolio.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> findPublished() {
        return projectRepository.findByStatusOrderByDisplayOrderAsc(Status.PUBLISHED)
                .stream()
                .map(this::toDto)
                .toList();
    }

    private ProjectDto toDto(Project project) {
        List<String> skillNames = project.getSkills().stream()
                .sorted(Comparator.comparingInt(Skill::getDisplayOrder))
                .map(Skill::getName)
                .toList();
        return new ProjectDto(project.getTitle(), project.getSlug(), project.getSummary(), skillNames);
    }
}
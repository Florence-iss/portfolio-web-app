package com.theingimyint.portfolio.serviceImpl;

import com.theingimyint.portfolio.dto.ProjectDetailDto;
import com.theingimyint.portfolio.dto.ProjectDto;
import com.theingimyint.portfolio.exception.ProjectNotFoundException;
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

    // ---------- public methods (from the ProjectService interface) ----------

    @Override
    public List<ProjectDto> findPublished() {
        return projectRepository.findByStatusOrderByDisplayOrderAsc(Status.PUBLISHED)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ProjectDetailDto findBySlug(String slug) {
        Project project = projectRepository.findBySlugAndStatus(slug, Status.PUBLISHED)
                .orElseThrow(() -> new ProjectNotFoundException(slug));

        return new ProjectDetailDto(
                project.getTitle(),
                project.getSummary(),
                project.getDescription(),
                project.getGithubUrl(),
                project.getDemoUrl(),
                sortedSkillNames(project));
    }

    // ---------- private helpers (only used inside this class) ----------

    private ProjectDto toDto(Project project) {
        return new ProjectDto(
                project.getTitle(),
                project.getSlug(),
                project.getSummary(),
                sortedSkillNames(project));
    }

    private List<String> sortedSkillNames(Project project) {
        return project.getSkills().stream()
                .sorted(Comparator.comparingInt(Skill::getDisplayOrder))
                .map(Skill::getName)
                .toList();
    }
}
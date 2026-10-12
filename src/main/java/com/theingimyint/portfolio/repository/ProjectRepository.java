package com.theingimyint.portfolio.repository;

import com.theingimyint.portfolio.model.Project;
import com.theingimyint.portfolio.model.Status;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @EntityGraph(attributePaths = "skills")
    List<Project> findByStatusOrderByDisplayOrderAsc(Status status);

    @EntityGraph(attributePaths = "skills")
    Optional<Project> findBySlugAndStatus(String slug, Status status);
}
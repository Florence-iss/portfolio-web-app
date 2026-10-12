package com.theingimyint.portfolio.repository;

import com.theingimyint.portfolio.model.Project;
import com.theingimyint.portfolio.model.Status;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @EntityGraph(attributePaths = "skills")
    List<Project> findByStatusOrderByDisplayOrderAsc(Status status);
}
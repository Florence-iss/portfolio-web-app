package com.theingimyint.portfolio.Controllers;

import com.theingimyint.portfolio.Model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProjectController {

    @GetMapping("/projects")
    public String list(Model model) {
        List<Project> projects = List.of(
                new Project("ReTech",
                        "E-waste collection platform (NUS-ISS team project, 7 members). "
                                + "I built the full collection officer module: dashboard with route map, "
                                + "bins to collect and collected, distance and time left, and damaged/lost bin reporting.",
                        List.of(".NET", "Kotlin", "JavaScript")),
                new Project("Docker Docs RAG Bot",
                        "Chatbot that answers questions from Docker's official docs using a Bedrock Knowledge Base, with a Streamlit web UI",
                        List.of("Python", "AWS Bedrock", "S3", "Streamlit", "RAG")),
                new Project("Portfolio Website",
                        "This site — Spring Boot, Thymeleaf, PostgreSQL",
                        List.of("Java", "Spring Boot", "Thymeleaf"))
        );
        model.addAttribute("projects", projects);
        return "projects";
    }
}
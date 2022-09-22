package com.example.projects.controller;

import com.example.projects.dto.ProjectDTORequest;
import com.example.projects.dto.ProjectDTOResponse;
import com.example.projects.dto.ProjectFullDTOResponse;
import com.example.projects.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping(path = "/projects")
    public void createProject(@RequestBody ProjectDTORequest request) {

        projectService.createProject(request);
    }

    @GetMapping(path = "/projects")
    public List<ProjectDTOResponse> getAllProjects() {

        return projectService.getAllProjects();

    }

    @GetMapping(path = "/projects/{id}")
    public ProjectDTOResponse getProjectById(@PathVariable(name = "id") Long projectId) {
        return projectService.getProjectById(projectId);
    }
    @GetMapping(path = "/projects/{id}/full")
    public ProjectFullDTOResponse getFullProjectById(@PathVariable(name = "id") Long id) {
        return projectService.getFullProjectById(id);
    }
}

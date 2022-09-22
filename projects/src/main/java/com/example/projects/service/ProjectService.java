package com.example.projects.service;

import com.example.projects.dto.ProjectDTORequest;
import com.example.projects.dto.ProjectDTOResponse;
import com.example.projects.dto.ProjectFullDTOResponse;

import java.util.List;

public interface ProjectService {
    void createProject(ProjectDTORequest request);

    List<ProjectDTOResponse> getAllProjects();

    ProjectDTOResponse getProjectById(Long projectId);

    ProjectFullDTOResponse getFullProjectById(Long id);
}

package com.example.projects.service.impl;

import com.example.projects.dto.*;
import com.example.projects.repository.ProjectRepository;
import com.example.projects.repository.TaskRepository;
import com.example.projects.service.ProjectService;
import com.example.projects.utils.ConverterDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    @Override
    public void createProject(ProjectDTORequest request) {
        var project = ConverterDTO.convertFromDTOToProject(request);
        projectRepository.save(project);

    }

    @Override
    public List<ProjectDTOResponse> getAllProjects() {

        return projectRepository.findAll()
                .stream()
                .map(project -> {

                    var tasksCount = taskRepository.findAllByProject(project).size();
                    return ConverterDTO.convertFromProjectToDto(project,tasksCount);

                })
                .toList();
    }

    @Override
    public ProjectDTOResponse getProjectById(Long projectId) {
        var project = projectRepository.findById(projectId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        var tasksCount = taskRepository.findAllByProject(project).size();

        return  ConverterDTO.convertFromProjectToDto(project,tasksCount);
    }

    @Override
    public ProjectFullDTOResponse getFullProjectById(Long id) {

        var project = projectRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        var tasks = taskRepository.findAllByProject(project);

        var tasksResponse = tasks.stream()
                .map(ConverterDTO::convertFRomTAskToDto)
                .toList();

        return ProjectFullDTOResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .tasks(tasksResponse)
                .build();
    }
}

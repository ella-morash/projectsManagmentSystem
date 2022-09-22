package com.example.projects.service.impl;

import com.example.projects.dto.TaskDTORequest;
import com.example.projects.repository.AssigneeRepository;
import com.example.projects.repository.ProjectRepository;
import com.example.projects.repository.TaskRepository;
import com.example.projects.service.TaskService;
import com.example.projects.utils.ConverterDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final AssigneeRepository assigneeRepository;
    private final ProjectRepository projectRepository;

    @Override
    public void createTask(TaskDTORequest request) {


        var assignee = assigneeRepository.findById(request.getAssigneeId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        var project = projectRepository.findById(request.getProjectId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        var task = ConverterDTO.convertFromDTOToTask(request,assignee,project);

        taskRepository.save(task);


    }
}

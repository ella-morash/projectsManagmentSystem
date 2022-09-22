package com.example.projects.controller;

import com.example.projects.dto.TaskDTORequest;
import com.example.projects.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(path = "/tasks")
    public void createTask(@RequestBody TaskDTORequest request) {
        taskService.createTask(request);
    }
}

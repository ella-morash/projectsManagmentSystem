package com.example.projects.service;

import com.example.projects.dto.TaskDTORequest;

public interface TaskService {
    void createTask(TaskDTORequest request);
}

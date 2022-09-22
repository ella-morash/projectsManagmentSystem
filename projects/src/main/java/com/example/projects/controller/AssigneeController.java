package com.example.projects.controller;

import com.example.projects.dto.AssigneeDTORequest;
import com.example.projects.service.AssigneeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AssigneeController {

    private final AssigneeService assigneeService;

    @PostMapping(path = "/assignee")
    public void createAssignee(@RequestBody AssigneeDTORequest request){

        assigneeService.createAssignee(request);

    }
}

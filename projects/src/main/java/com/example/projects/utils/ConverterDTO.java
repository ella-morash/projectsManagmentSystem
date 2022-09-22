package com.example.projects.utils;


import com.example.projects.dto.*;
import com.example.projects.entity.Assignee;
import com.example.projects.entity.Project;
import com.example.projects.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverterDTO {

    public static Task convertFromDTOToTask(TaskDTORequest request,Assignee assignee,Project project) {



        return Task.builder()
                .name(request.getName())
                .description(request.getDescription())
                .assignee(assignee)
                .project(project)
                .status(request.getStatus())
                .build();
    }

    public static Assignee convertFromDTOToAssignee(AssigneeDTORequest request ) {
        return  Assignee.builder()
                .name(request.getName())
                .build();
    }

    public static Project convertFromDTOToProject(ProjectDTORequest request){
        return Project.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public static ProjectDTOResponse convertFromProjectToDto(Project project,Integer tasksCount) {
        return ProjectDTOResponse.builder()
                .name(project.getName())
                .id(project.getId())
                .tasksCount(tasksCount)
                .build();
    }

    public static TaskDTOResponse convertFRomTAskToDto(Task task) {
        return TaskDTOResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .assignee(AssigneeDTOResponse.builder()
                        .id(task.getAssignee().getId())
                        .name(task.getAssignee().getName())
                        .build())
                .build();
    }


}



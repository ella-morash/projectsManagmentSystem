package com.example.projects.dto;


import com.example.projects.entity.taskstatus.Status;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskDTOResponse {
    private Long id;
    private String name;
    private String description;
    private Status status;
    private AssigneeDTOResponse assignee;
}

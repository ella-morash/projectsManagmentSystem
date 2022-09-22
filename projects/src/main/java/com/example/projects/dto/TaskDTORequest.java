package com.example.projects.dto;


import com.example.projects.entity.Assignee;
import com.example.projects.entity.Project;
import com.example.projects.entity.taskstatus.Status;
import com.example.projects.entity.taskstatus.StatusConverter;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskDTORequest {


    private String name;

    private String description;


    private Status status;

    private Long projectId;

    private Long assigneeId;
}

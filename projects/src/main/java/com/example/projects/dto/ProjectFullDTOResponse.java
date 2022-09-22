package com.example.projects.dto;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProjectFullDTOResponse {
    private Long id;
    private String name;
    private String description;
    private List<TaskDTOResponse> tasks;
}

package com.example.projects.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProjectDTOResponse {

    private Long id;
    private String name;
    private Integer tasksCount;
}

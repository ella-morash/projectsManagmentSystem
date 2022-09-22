package com.example.projects.dto;

import lombok.*;

import javax.persistence.Column;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProjectDTORequest {

    private String name;

    private String description;
}

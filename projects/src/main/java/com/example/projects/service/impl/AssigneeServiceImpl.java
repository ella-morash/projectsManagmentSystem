package com.example.projects.service.impl;

import com.example.projects.dto.AssigneeDTORequest;
import com.example.projects.repository.AssigneeRepository;
import com.example.projects.service.AssigneeService;
import com.example.projects.utils.ConverterDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssigneeServiceImpl implements AssigneeService {

    private final AssigneeRepository assigneeRepository;
    @Override
    public void createAssignee(AssigneeDTORequest request) {

        var assignee = ConverterDTO.convertFromDTOToAssignee(request);
        assigneeRepository.save(assignee);


    }
}

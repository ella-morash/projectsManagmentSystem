package com.example.projects.repository;

import com.example.projects.entity.Assignee;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AssigneeRepository extends JpaRepository<Assignee,Long> {
}

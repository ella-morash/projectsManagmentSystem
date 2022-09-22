package com.example.projects.repository;

import com.example.projects.entity.Project;
import com.example.projects.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByProject(Project project);


}

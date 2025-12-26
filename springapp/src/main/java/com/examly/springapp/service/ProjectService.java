package com.examly.springapp.service;

import com.examly.springapp.model.Project;
import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project updateProject(Long id, Project project);

    List<Project> getProjectsByStatus(String status);
}

package com.examly.springapp.service;

import com.examly.springapp.model.Project;
import com.examly.springapp.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public Project createProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public Project updateProject(Long id, Project project) {
        Project existingProject = projectRepo.findById(id).orElse(null);
        if (existingProject != null) {
            existingProject.setProjectName(project.getProjectName());
            existingProject.setDescription(project.getDescription());
            existingProject.setStatus(project.getStatus());
            return projectRepo.save(existingProject);
        }
        return null;
    }

    @Override
    public List<Project> getProjectsByStatus(String status) {
        return projectRepo.findByStatus(status);
    }
}

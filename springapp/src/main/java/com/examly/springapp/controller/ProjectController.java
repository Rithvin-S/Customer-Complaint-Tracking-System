package com.examly.springapp.controller;

import com.examly.springapp.model.Project;
import com.examly.springapp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(
            @PathVariable Long id,
            @RequestBody Project project) {

        return new ResponseEntity<>(
                projectService.updateProject(id, project),
                HttpStatus.OK
        );
    }

    @GetMapping("/status/{status}")
public ResponseEntity<?> getProjectsByStatus(@PathVariable String status) {

    List<Project> projects = projectService.getProjectsByStatus(status);

    if (projects.isEmpty()) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("No projects found with status: " + status);
    }

    return ResponseEntity.ok(projects);
}

}

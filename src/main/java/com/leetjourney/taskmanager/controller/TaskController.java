package com.leetjourney.taskmanager.controller;

import com.leetjourney.taskmanager.dto.TaskResponse;
import com.leetjourney.taskmanager.service.TaskService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService  taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findAll() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> findById(
            @PathVariable
            @Positive(
                    message = "Task id must be greater than zero"
            )
            Long id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }
}

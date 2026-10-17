package com.leetjourney.taskmanager.service;

import com.leetjourney.taskmanager.dto.TaskResponse;
import com.leetjourney.taskmanager.entity.Task;
import com.leetjourney.taskmanager.exception.ResourceNotFoundException;
import com.leetjourney.taskmanager.repository.TaskRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskResponse::from)
                .toList();
    }

    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Task with id " + id + " not found!"
                ));

        return TaskResponse.from(task);
    }

    public void deleteTaskById(Long id) {
        taskRepository.delete(this.getEntityById(id));
    }

    private Task getEntityById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Task with id " + id + " not found!"
                ));
    }
}

//  org.springframework.stereotype.Service
/*
 * @Service
 *  Indicates that an annotated class is a "Service".
 *  Originally defined by Domain-Driven Design (Evans, 2003) as "an operation offered as an interface that stands alone in the model, with no encapsulated state."
 */
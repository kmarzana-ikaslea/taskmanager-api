package com.leetjourney.taskmanager.service;

import com.leetjourney.taskmanager.dto.PageResponse;
import com.leetjourney.taskmanager.dto.TaskResponse;
import com.leetjourney.taskmanager.entity.Task;
import com.leetjourney.taskmanager.exception.ResourceNotFoundException;
import com.leetjourney.taskmanager.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public PageResponse<TaskResponse> getAllTasks(int page, int size) {
        Page<TaskResponse> taskPage = taskRepository
                .findAll(PageRequest.of(page, size))
                .map(TaskResponse::from);

        return new PageResponse<>(
                taskPage.getContent(),
                taskPage.getNumber(),
                taskPage.getSize(),
                taskPage.getTotalElements(),
                taskPage.getTotalPages(),
                taskPage.isFirst(),
                taskPage.isLast()
        );
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
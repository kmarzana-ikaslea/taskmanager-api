package com.leetjourney.taskmanager.dto;

import com.leetjourney.taskmanager.entity.Task;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TaskResponse(
        Long id,
        String title,
        String description,
        Boolean completed,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static TaskResponse from(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.getCompleted())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }
}

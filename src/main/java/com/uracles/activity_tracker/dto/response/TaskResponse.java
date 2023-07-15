package com.uracles.activity_tracker.dto.response;

import com.uracles.activity_tracker.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class TaskResponse {
    private Long id;

    private String title;

    private LocalDateTime createdTime;

//    private LocalDateTime completedAt;

    private LocalDate updatedAt;

    private TaskStatus taskStatus;

    private String description;

}

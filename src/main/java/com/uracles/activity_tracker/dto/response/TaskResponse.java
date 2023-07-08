package com.uracles.activity_tracker.dto.response;

import com.uracles.activity_tracker.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskResponse {
    private Long taskId;

    private Long appUserId;

    private String title;

    private String description;

    private TaskStatus taskStatus;
}

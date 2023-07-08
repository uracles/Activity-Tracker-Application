package com.uracles.activity_tracker.dto.request;

import com.uracles.activity_tracker.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequest {
    @NotBlank(message = "Title is needed")
    private String title;

    @NotBlank(message = "Description is needed ")
    private String description;

    @NotBlank(message = "Select the task status")
    private TaskStatus taskStatus;
}

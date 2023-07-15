package com.uracles.activity_tracker.utils;

import com.uracles.activity_tracker.dto.response.AppUserResponse;
import com.uracles.activity_tracker.dto.response.TaskResponse;
import com.uracles.activity_tracker.entities.AppUser;
import com.uracles.activity_tracker.entities.Task;

import java.time.LocalDateTime;

public class Mapper {
        public static AppUserResponse createResponseDto(AppUser appUser) {
        return AppUserResponse
                .builder()
                .id(appUser.getId())
                .email(appUser.getEmail())
                .name(appUser.getName())
                .build();
    }

    public static TaskResponse convertToTaskResponse(Task task){
        return TaskResponse.builder()
                .id(task.getTask_Id())
                .title(task.getTitle())
                .description(task.getDescription())
                .createdTime(LocalDateTime.now())
//                .completedAt(null)
                .taskStatus(task.getTaskStatus())
                .build();
    }
}

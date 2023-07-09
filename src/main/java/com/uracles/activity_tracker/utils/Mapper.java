package com.uracles.activity_tracker.utils;

import com.uracles.activity_tracker.dto.response.AppUserResponse;
import com.uracles.activity_tracker.dto.response.TaskResponse;
import com.uracles.activity_tracker.entities.AppUser;
import com.uracles.activity_tracker.entities.Task;

public class Mapper {
//    public static AppUserLoginResponse createResponseDto(AppUser appUser) {
        public static AppUserResponse createResponseDto(AppUser appUser) {

//        return AppUserLoginResponse.builder()
        return AppUserResponse
                .builder().id(appUser.getId()).email(appUser.getEmail()).name(appUser.getName()).build();
    }

    public static TaskResponse convertToTaskResponse(Task task){
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
//                .taskStatus(task.getTaskStatus())
                .build();
    }
}

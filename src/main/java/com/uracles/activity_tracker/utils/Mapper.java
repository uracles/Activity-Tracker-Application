package com.uracles.activity_tracker.utils;

import com.uracles.activity_tracker.dto.response.AppUserLoginResponse;
import com.uracles.activity_tracker.dto.response.AppUserSignUpResponse;
import com.uracles.activity_tracker.dto.response.TaskResponse;
import com.uracles.activity_tracker.entities.AppUser;
import com.uracles.activity_tracker.entities.Task;

public class Mapper {
//    public static AppUserLoginResponse createResponseDto(AppUser appUser) {
        public static AppUserSignUpResponse createResponseDto(AppUser appUser) {

//        return AppUserLoginResponse.builder()
        return AppUserSignUpResponse
                .builder().id(appUser.getId()).email(appUser.getEmail()).name(appUser.getName()).build();
    }

    public static TaskResponse generateTaskResponse(Task task){
        return TaskResponse.builder()
                .taskId(task.getId()).title(task.getTitle()).description(task.getDescription()).taskStatus(task.getTaskStatus()).build();
    }
}

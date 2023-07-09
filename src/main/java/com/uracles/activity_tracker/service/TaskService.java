package com.uracles.activity_tracker.service;

import com.uracles.activity_tracker.dto.request.TaskRequest;
import com.uracles.activity_tracker.dto.response.TaskResponse;
import com.uracles.activity_tracker.entities.Task;
import com.uracles.activity_tracker.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    TaskResponse viewTask(Long taskId);

    List<TaskResponse> viewAllTask(Long appUserId);

    List<TaskResponse> moveTasksByStatus(TaskStatus status, Long appUserId);//task id as arg

    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> viewTasksByStatus(TaskStatus status, Long appUserId);

    Task updateTaskById(Long taskId, TaskRequest taskCreatedDto);

    void deleteTask(Long task_id);



}

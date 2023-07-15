package com.uracles.activity_tracker.service;

import com.uracles.activity_tracker.dto.request.TaskRequest;
import com.uracles.activity_tracker.dto.response.TaskResponse;
import com.uracles.activity_tracker.entities.Task;
import com.uracles.activity_tracker.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    TaskResponse viewTask(Long taskId);

    List<TaskResponse> viewAllTask(Long appUserId);

    TaskResponse moveTasksByStatus(TaskStatus status, Long appUserId, Long taskId);//task id as arg

    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> viewTasksByStatus(TaskStatus status, Long appUserId);

    TaskResponse updateTaskById(Long taskId, TaskRequest taskCreatedDto);

    String deleteTask(Long task_id);



}

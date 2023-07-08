package com.uracles.activity_tracker.service;

import com.uracles.activity_tracker.dto.request.TaskRequest;
import com.uracles.activity_tracker.dto.response.TaskResponse;
import com.uracles.activity_tracker.entities.Task;
import com.uracles.activity_tracker.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    TaskResponse viewTask(Long taskId);

    List<Task> viewAllTask();

    List<TaskResponse> viewTasksByStatus(TaskStatus status, Long studentId);

    Task CreateTask(TaskRequest request);

    Task updateTaskById(Long taskId, TaskRequest taskCreatedDto);

    void deleteTask(Long task_id);



}

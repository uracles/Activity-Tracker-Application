package com.merakool.trackerApp.service;

import com.merakool.trackerApp.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Long taskId);
    List<Task> getAllTasks();
    List<Task> getPendingTasks();
    List<Task> getDoneTasks();
    List<Task> getInProgressTasks();
    void moveTaskToPending(Long taskId);
    void moveTaskToDone(Long taskId);
    Task updateTask(Long taskId, Task task);
    void deleteTask(Long taskId);
}

package com.merakool.trackerApp.service.implementation;

import com.merakool.trackerApp.entity.Task;
import com.merakool.trackerApp.repository.TaskRepository;
import com.merakool.trackerApp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getPendingTasks() {
        return taskRepository.findByStatus("pending");
    }

    @Override
    public List<Task> getDoneTasks() {
        return taskRepository.findByStatus("done");
    }

    @Override
    public List<Task> getInProgressTasks() {
        return taskRepository.findByStatus("in progress");
    }

    @Override
    public void moveTaskToPending(Long taskId) {
        Task task = getTaskById(taskId);
        if (task != null) {
            task.setStatus("pending");
            task.setCompletedAt(null);
            taskRepository.save(task);
        }
    }

    @Override
    public void moveTaskToDone(Long taskId) {
        Task task = getTaskById(taskId);
        if (task != null) {
            task.setStatus("done");
            task.setCompletedAt(LocalDateTime.now());
            taskRepository.save(task);
        }
    }

    @Override
    public Task updateTask(Long taskId, Task task) {
        Task existingTask = getTaskById(taskId);
        if (existingTask != null) {
            // Update the relevant fields of the existing task
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setUpdatedAt(LocalDateTime.now());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
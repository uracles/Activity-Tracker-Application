package com.uracles.activity_tracker.service.implementation;

import com.uracles.activity_tracker.dto.request.TaskRequest;
import com.uracles.activity_tracker.dto.response.TaskResponse;
import com.uracles.activity_tracker.entities.AppUser;
import com.uracles.activity_tracker.entities.Task;
import com.uracles.activity_tracker.enums.TaskStatus;
import com.uracles.activity_tracker.exception.AppUserException;
import com.uracles.activity_tracker.exception.TaskNotExistException;
import com.uracles.activity_tracker.repository.AppUserRepository;
import com.uracles.activity_tracker.repository.TaskRepository;
import com.uracles.activity_tracker.service.TaskService;
import com.uracles.activity_tracker.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final AppUserRepository appUserRepository;

    @Override
    public TaskResponse viewTask(Long taskId) {
        return Mapper.convertToTaskResponse(taskRepository.findById(taskId)
                        .orElseThrow(() ->
                                new TaskNotExistException("no task is not found for id")));
    }

    @Override
    public List<TaskResponse> viewAllTask(Long appUserId) {

        return taskRepository.findByAppUserId(appUserId)
                .stream().map(Mapper::convertToTaskResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse moveTasksByStatus(TaskStatus newStatus, Long userId, Long taskId) {
        // Get the user
        Optional<AppUser> user = appUserRepository.findById(userId);
        if (user.isEmpty()) {
            throw new AppUserException("User not found");
        }

        AppUser user1 = user.get();

        // Get the task
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isEmpty()) {
            throw new AppUserException("No task for the provided id");
        }

        Task existingTask = task.get();
        // Check if the user is authorized to change the status
        if (!existingTask.getAppUser().getId().equals(user1.getId())) {
            throw new AppUserException("Not authorized to change status");
        }

        // Update the task status
        existingTask.setTaskStatus(newStatus);

        // Update completedAt timestamp if the newStatus is DONE
        if (newStatus == TaskStatus.COMPLETED) {
            existingTask.setCompletedAt(LocalDateTime.now());
        } else {
            existingTask.setUpdatedAt(LocalDate.now());
        }

        // Save the updated task
        taskRepository.save(existingTask);

        // Build and return the response DTO
        return TaskResponse.builder()
                .title(existingTask.getTitle())
                .description(existingTask.getDescription())
                .taskStatus(existingTask.getTaskStatus())
                .updatedAt(existingTask.getUpdatedAt())
//                .completedAt(existingTask.getCompletedAt())
                .build();
    }

//            return Mapper.convertToTaskResponse(taskRepository.saveAndFlush(task));


    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {

        return Mapper.convertToTaskResponse(taskRepository.save(
                Task.builder()
                        .title(taskRequest.getTitle())
                        .description(taskRequest.getDescription())
                        .taskStatus(TaskStatus.PENDING)
                        .appUser(appUserRepository.findById(taskRequest.getId())
                                .orElseThrow(() -> new AppUserException("user not available")))
                        .createdTime(LocalDateTime.now())
                        .build()
        ));
    }

    @Override
    public TaskResponse updateTaskById(Long taskId, TaskRequest taskUpdateRequest) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (!taskOptional.isPresent()) {
            throw new TaskNotExistException("Task not found");
        }

        Task task = taskOptional.get();
        task.setTitle(taskUpdateRequest.getTitle());
        task.setDescription(taskUpdateRequest.getDescription());
        task.setUpdatedAt(LocalDate.now());

        taskRepository.save(task);

        return Mapper.convertToTaskResponse(task);
    }



    @Override
    public List<TaskResponse> viewTasksByStatus(TaskStatus status, Long appUserId) {
        return taskRepository.findTasksByAppUserIdAndTaskStatus(appUserId, status).stream().map(Mapper::convertToTaskResponse).collect(Collectors.toList());
    }


    @Override
    public String deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
        return "task deleted successfully";
    }
}

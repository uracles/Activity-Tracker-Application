package com.uracles.activity_tracker.service.implementation;

import com.uracles.activity_tracker.dto.request.TaskRequest;
import com.uracles.activity_tracker.dto.response.TaskResponse;
import com.uracles.activity_tracker.entities.Task;
import com.uracles.activity_tracker.enums.TaskStatus;
import com.uracles.activity_tracker.exception.AppUserException;
import com.uracles.activity_tracker.repository.AppUserRepository;
import com.uracles.activity_tracker.repository.TaskRepository;
import com.uracles.activity_tracker.service.TaskService;
import com.uracles.activity_tracker.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final AppUserRepository appUserRepository;
    @Override
    public TaskResponse viewTask(Long taskId) {
        return null;
    }

    @Override
    public List<Task> viewAllTask() {
        return null;
    }

    @Override
    public List<TaskResponse> viewTasksByStatus(TaskStatus status, Long studentId) {
        return null;
    }

    @Override
    public Task CreateTask(TaskRequest taskRequest) {
//        Long user_id = (Long) httpSession.getAttribute("user_id");
//        userRepo.findById(user_id).orElseThrow(() -> new AppUserException("user doesnt exist"));

        return Mapper.generateTaskResponse(taskRepository.save(
                Task.builder()
                        .title(taskRequest.getTitle())
                        .description(taskRequest.getDescription())
                        .taskStatus(TaskStatus.PENDING)
                        .appUser(appUserRepository.findById()
                                .orElseThrow(() -> new AppUserException("user doesnt exist")))
                        .build()
        ));
    }

    @Override
    public Task updateTaskById(Long taskId, TaskRequest taskCreatedDto) {
        return null;
    }

    @Override
    public void deleteTask(Long task_id) {
        taskRepository.deleteById(task_id);
    }
}

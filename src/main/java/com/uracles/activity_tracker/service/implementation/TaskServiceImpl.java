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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final AppUserRepository appUserRepository;
    private final HttpSession httpSession;
    @Override
    public TaskResponse viewTask(Long taskId) {
        return Mapper.
                convertToTaskResponse(taskRepository.findById(taskId)
                .orElseThrow(()->
                new TaskNotExistException("task is not found with id provided")));

//        public TaskViewDto viewTask(Long task_id) {// noted
//            Long user_id = (Long) httpSession.getAttribute("user_id");
//            userRepo.findById(user_id)
//                    .orElseThrow(() -> new NotFoundException("sorry! this task doesnt exist"));
//
//            Optional<Task> taskOptional = taskRepo.findById(task_id);
//            Task task = taskOptional.orElseThrow(() -> new TaskDoesntExistException("Task does not exist"));
//
//            boolean isTaskOwner = task.getUserId().equals(user_id);
//
//            if(!isTaskOwner) throw new TaskDoesntExistException("Task does not exist");
//
//            return TaskViewDto.builder()
//                    .taskId(task.getId())
//                    .userId(task.getUserId())
//                    .title(task.getTitle())
//                    .description(task.getDescription())
//                    .build();
//        }
    }

    @Override
    public List<TaskResponse> viewAllTask(Long appUserId) {

            return taskRepository.findByAppUserId(appUserId)
                    .stream().map(Mapper::convertToTaskResponse)
                    .collect(Collectors.toList());


//        public List<Task> viewAllTask() {
//            Long user_id = (Long) httpSession.getAttribute("user_id");
//
//            Optional<User> optionalUser = userRepo.findById(user_id);
//            if (optionalUser.isPresent())
//                return taskRepo.findByUserId(user_id);
//            else
//                throw new NotFoundException("user doesnt exist!");
//        return null;
    }

    @Override
    public List<TaskResponse> moveTasksByStatus(TaskStatus status, Long studentId) {

//            Task task= getTask(taskId);
//
//            if (task.getStatus()==status) throw new IllegalEntityStateException("Illegal Object Update",
//                    "Status cannot be changed to same state");
//            if(task.getStatus()==TaskStatus.DONE) task.setCompletedAt(null);
//            task.setStatus(status);// change the state of the object
//            if(task.getStatus()==TaskStatus.DONE) task.setCompletedAt(new Date());
//            return Mapper.taskToTaskDto(taskRepository.saveAndFlush(task));
//


        return null;
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {

//        AppUser appUser = appUserRepository.findById(taskRequest.getId())
//                .orElseThrow(() -> new AppUserException("User not available"));
//
//        Task task = Task.builder()
//                .title(taskRequest.getTitle())
//                .description(taskRequest.getDescription())
//                .taskStatus(TaskStatus.PENDING)
//                .appUser(appUser)
//                .build();
//
//        Task savedTask = taskRepository.save(task);
//
//        return TaskResponse;


//        Long appUser_id = (Long) httpSession.getAttribute("appUser_id");
//        appUserRepository.findById(user_id).orElseThrow(() -> new AppUserException("user doesnt exist"));
//
        return Mapper.convertToTaskResponse(taskRepository.save(
                Task.builder()
                        .title(taskRequest.getTitle())
                        .description(taskRequest.getDescription())
                        .taskStatus(TaskStatus.PENDING)
                        .appUser(appUserRepository.findById(taskRequest.getId())
                                .orElseThrow(()->new AppUserException("user not available")))
                        .build()
        ));

    }

    @Override
    public Task updateTaskById(Long taskId, TaskRequest taskUpdate) {

        Long Id = (Long) httpSession.getAttribute("user_id");
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        Task oldTask = taskOptional.orElseThrow(() ->
                new TaskNotExistException("Task does not exist"));


        String newTitle = taskUpdate.getTitle();
        String newDescription = taskUpdate.getDescription();
//        TaskStatus newTaskStatus = taskUpdate.getTaskStatus();


        if (newTitle != null && !newTitle.isBlank()) {
            oldTask.setTitle(newTitle);
        }
            if (newDescription != null && !newDescription.isBlank()) {
                oldTask.setDescription(newDescription);
            }
//                    if (newTaskStatus != null && !newTaskStatus.toString().isBlank()) {
//                        oldTask.setTaskStatus(newTaskStatus);
//                    }

        return taskRepository.save(oldTask);

//        public TaskDto updateTask(TaskUpdateDto taskUpdateRequest, Long taskId) {
//            Task task = getTask(taskId);
//            task.setTitle(taskUpdateRequest.getTitle());
//            task.setDescription(taskUpdateRequest.getDescription());
//            taskRepository.save(task);
//            return Mapper.taskToTaskDto(task);
//
//        }

    }

    @Override
    public List<TaskResponse> viewTasksByStatus(TaskStatus status, Long appUserId) {

        return taskRepository.findTasksByAppUserIdAndTaskStatus(appUserId, status)
                .stream().map(Mapper::convertToTaskResponse)
                .collect(Collectors.toList());

    }


    @Override
    public void deleteTask(Long task_id) {
        taskRepository.deleteById(task_id);


//        Long user_id = (Long) httpSession.getAttribute("user_id");
//        boolean exists = appUserRepository.existsById(user_id);
//
//        if (!exists) {
//            throw new AppUserException("user not found");
//        } else {
//            taskRepository.findById(task_id);
//        }
    }
}

package com.uracles.activity_tracker.controller;

import com.uracles.activity_tracker.dto.request.TaskRequest;
import com.uracles.activity_tracker.dto.response.TaskResponse;
import com.uracles.activity_tracker.entities.Task;
import com.uracles.activity_tracker.enums.TaskStatus;
import com.uracles.activity_tracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity<?> create(@RequestBody @Valid TaskRequest request) {
        var response = taskService.createTask(request);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{taskId}")
    public ResponseEntity<?> viewTask(@PathVariable Long taskId) {
        var response = taskService.viewTask(taskId);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/user/{status}/{appUserId}")
    public ResponseEntity<List<?>> viewByTaskStatus(@PathVariable TaskStatus status, @PathVariable Long appUserId) {
        var response = taskService.viewTasksByStatus(status, appUserId);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/viewAllTasks/{appUserId}")
    public ResponseEntity<List<?>> viewAllTasks(@PathVariable Long appUserId) {
        var response = taskService.viewAllTask(appUserId);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{taskId}/updateTask")
    public ResponseEntity<?> updateTask(@Valid @RequestBody TaskRequest taskUpdateRequest, @PathVariable Long taskId){
        var response = taskService.updateTaskById(taskId, taskUpdateRequest );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{task_id}/deleteTask")
    public ResponseEntity<?> deleteTask(@PathVariable("task_id") Long task_id){
        var response = taskService.deleteTask(task_id);
         return ResponseEntity.ok(response);
        }


    @PatchMapping("/changeTaskStatus/{status}/{taskId}/{appUserId}")
    public ResponseEntity<?> changeTaskStatus(@PathVariable TaskStatus status, @PathVariable Long taskId, @PathVariable Long appUserId){
        var response = taskService.moveTasksByStatus(status, appUserId, taskId);
        return ResponseEntity.ok(response);
    }
}
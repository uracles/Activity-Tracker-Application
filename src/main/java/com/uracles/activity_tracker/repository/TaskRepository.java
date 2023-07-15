package com.uracles.activity_tracker.repository;

import com.uracles.activity_tracker.entities.AppUser;
import com.uracles.activity_tracker.entities.Task;
import com.uracles.activity_tracker.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findById(Long id);

    List <Task> findByAppUserId(Long user_Id);

    List<Task> findTasksByAppUserIdAndTaskStatus  (Long userId, TaskStatus status);

}

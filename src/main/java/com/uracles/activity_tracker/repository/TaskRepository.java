package com.uracles.activity_tracker.repository;

import com.uracles.activity_tracker.entities.AppUser;
import com.uracles.activity_tracker.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<AppUser, Long> {
    Optional<Task> findByAppUserId(Long id);
}

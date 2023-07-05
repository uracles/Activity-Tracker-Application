package com.merakool.trackerApp.repository;

import com.merakool.trackerApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long > {
    List<Task> findByStatus(String status);
    List<Task> findByAppUserUsername(String username);
}

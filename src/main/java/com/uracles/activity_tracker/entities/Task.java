package com.uracles.activity_tracker.entities;

import com.uracles.activity_tracker.enums.TaskStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_Id;

    private String title;

    private String description;

    @CreatedDate
    @Column(name = "created_time")
    private LocalDateTime createdTime;

//    @Column(name = "created_time")
//    private LocalDateTime createdTime;

    @Column(name = "completed_time")
    private LocalDateTime completedAt;

    @LastModifiedDate
    private LocalDate updatedAt;

//    private Timestamp completedAt;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name="appUser_id", referencedColumnName = "id")
    private AppUser appUser;

}

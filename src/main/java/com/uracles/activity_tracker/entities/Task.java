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
    private Long id;

    private String title;

    private String description;

    @CreatedDate
    private Timestamp createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;
    private LocalDateTime completedAt;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name="appUser_id", referencedColumnName = "id")
    private AppUser appUser;

}

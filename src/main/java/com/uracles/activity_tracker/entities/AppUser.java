package com.uracles.activity_tracker.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
}

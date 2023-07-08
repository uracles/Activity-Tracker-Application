package com.uracles.activity_tracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class AppUserSignUpResponse {
    private Long id;
    private String name;
    private String email;
   // private String password;
}

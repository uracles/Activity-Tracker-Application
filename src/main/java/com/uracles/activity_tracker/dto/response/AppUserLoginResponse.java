package com.uracles.activity_tracker.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserLoginResponse {
    private Long id;
    private String name;
    private String email;
}

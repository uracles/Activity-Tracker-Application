package com.uracles.activity_tracker.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
@Builder
public class AppUserLoginRequest {
    @Email(message = "please provide a valid email")
    @NotBlank(message = "Email is required, please provide a valid email")
    private String email;

    @Size(min=6, max=10, message="password must be 6 to 10 characters")
    @NotBlank(message = "Provide your password")
    private String password;
}

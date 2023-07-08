package com.uracles.activity_tracker.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
public class AppUserException extends RuntimeException {
    private final String message;

    private HttpStatus status;

    private final LocalDateTime time = LocalDateTime.now();

    public AppUserException(String message) {
        this.message = message;
    }

    public AppUserException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}

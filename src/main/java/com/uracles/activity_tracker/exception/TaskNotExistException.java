package com.uracles.activity_tracker.exception;

import lombok.Getter;

@Getter
public class TaskNotExistException extends RuntimeException{
        public TaskNotExistException(String message) {

        }
}

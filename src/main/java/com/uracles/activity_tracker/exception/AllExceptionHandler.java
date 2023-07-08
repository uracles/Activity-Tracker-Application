package com.uracles.activity_tracker.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(AppUserException.class)
    public ResponseEntity<?> handlingOurOwnException(AppUserException exception) {
        return ResponseEntity.badRequest().body(exception.getLocalizedMessage());
    }

    @ExceptionHandler(TaskNotExistException.class)
    public ResponseEntity<?> handlingOurOwnException2(TaskNotExistException exception) {
        return ResponseEntity.badRequest().body(exception.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>handleGlobalExceptions(MethodArgumentNotValidException ex, WebRequest request){
        String[] errors = ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toArray(String[]::new);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}

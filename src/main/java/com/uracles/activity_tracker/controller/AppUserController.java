package com.uracles.activity_tracker.controller;

import com.uracles.activity_tracker.dto.request.AppUserRequest;
import com.uracles.activity_tracker.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody @Valid AppUserRequest request){
        var response = appUserService.registerUser(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser (@RequestBody @Valid AppUserRequest appUserLoginRequest){
        var loginResponse = appUserService.loginUser(appUserLoginRequest.getEmail(), appUserLoginRequest.getPassword());
        return ResponseEntity.ok(loginResponse);
    }


    @DeleteMapping("/deleteUser/{appUserId}")
    public ResponseEntity<?> deleteUser(@PathVariable("appUserId") Long appUserId){
        var response = appUserService.deleteUser(appUserId);
        return ResponseEntity.ok(response);
    }


     @GetMapping("/{id}")
    public ResponseEntity<?> findAppUser(@PathVariable Long id){
         var response = appUserService.viewAppUser(id);
         return ResponseEntity.ok(response);
    }
}

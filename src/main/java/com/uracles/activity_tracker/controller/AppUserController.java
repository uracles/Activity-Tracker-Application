package com.uracles.activity_tracker.controller;

import com.uracles.activity_tracker.dto.request.AppUserLoginRequest;
import com.uracles.activity_tracker.dto.request.AppUserSignUpRequest;
import com.uracles.activity_tracker.dto.response.AppUserLoginResponse;
import com.uracles.activity_tracker.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody @Valid AppUserSignUpRequest request){
        var response = appUserService.registerUser(request);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser (@RequestBody AppUserLoginRequest appUserLoginRequest, HttpServletRequest request){
//        var loginResponse = appUserService.loginUser(appUserLoginRequest.getEmail(), appUserLoginRequest.getPassword());
//        return ResponseEntity.ok(loginResponse);
//    }


//    @DeleteMapping("/deleteUser")
//    public ResponseEntity<String> deleteUser(){
//        appUserService.deleteAppUser();
//        return new ResponseEntity<>("user deleted successfully", HttpStatus.NO_CONTENT);
//    }



    // @GetMapping("/{id}")
//    public ResponseEntity<AppUserResponseDto> getAppUser(@PathVariable Long id){
//        return new ResponseEntity<>(appUserService.getAppUser(id),HttpStatus.ACCEPTED);
//    }
}

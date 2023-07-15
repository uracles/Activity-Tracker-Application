package com.uracles.activity_tracker.service;

import com.uracles.activity_tracker.dto.request.AppUserRequest;
import com.uracles.activity_tracker.dto.response.AppUserResponse;

public interface AppUserService {
    AppUserResponse registerUser(AppUserRequest request);
    AppUserResponse loginUser(String email, String password);
    AppUserResponse viewAppUser(Long id);
//    String deleteUser();
    String deleteUser(Long appUserId);
}

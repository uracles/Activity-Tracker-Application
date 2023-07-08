package com.uracles.activity_tracker.service;

import com.uracles.activity_tracker.dto.request.AppUserSignUpRequest;
import com.uracles.activity_tracker.dto.response.AppUserLoginResponse;
import com.uracles.activity_tracker.dto.response.AppUserSignUpResponse;

public interface AppUserService {
    AppUserSignUpResponse registerUser(AppUserSignUpRequest request);
//    AppUserLoginResponse loginUser(String email, String password);
//
//    AppUserLoginResponse getAppUser(Long id);
//    String deleteUser();
}

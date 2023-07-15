package com.uracles.activity_tracker.service.implementation;

import com.uracles.activity_tracker.dto.request.AppUserRequest;
import com.uracles.activity_tracker.dto.response.AppUserResponse;
import com.uracles.activity_tracker.entities.AppUser;
import com.uracles.activity_tracker.exception.AppUserException;
import com.uracles.activity_tracker.repository.AppUserRepository;
import com.uracles.activity_tracker.service.AppUserService;
import com.uracles.activity_tracker.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;

    @Override
    public AppUserResponse registerUser(AppUserRequest request) {

        String userEmail = request.getEmail();
        boolean appUserExist = appUserRepository.existsByEmail(userEmail);
        if (appUserExist)
            throw new AppUserException("User already exist, provide a different email");

        return Mapper.createResponseDto(appUserRepository.save(AppUser.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())

                .build()
        ));

    }


    @Override
    public AppUserResponse loginUser(String email, String password){
        AppUser appUser = appUserRepository.findByEmail(email)
                .orElseThrow(()-> new AppUserException("User not Found OR wrong email and password"));
        return Mapper.createResponseDto(appUser);

    }

    @Override
    public AppUserResponse viewAppUser(Long id) {
        return Mapper.createResponseDto (appUserRepository.findById(id).orElseThrow(
                ()->new AppUserException("App User not Found")));
    }


    @Override
    public String deleteUser(Long appUserId) {

        Optional<AppUser> optionalAppUser = appUserRepository.findById(appUserId);
        if (optionalAppUser.isEmpty()) {
            throw new AppUserException("user not found");
        } else {
            AppUser appUser = optionalAppUser.get();
            appUserRepository.delete(appUser);

        return "user deleted successfully";
        }
    }
}


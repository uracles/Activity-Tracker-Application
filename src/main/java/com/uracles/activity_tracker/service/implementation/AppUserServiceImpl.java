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

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final HttpSession httpSession;

    @Override
    public AppUserResponse registerUser(AppUserRequest request) {

//        Optional<AppUser> appUser = appUserRepository.findByEmail(request.getEmail());
//        if (appUser.isPresent()) {
//            throw new AppUserException("User already exist, provide a different email");
//        }
//
//        AppUser newAppUser = AppUser.builder()
//                .name(request.getName())
//                .email(request.getEmail())
//                .password(request.getPassword())
//                .build();
//
//        AppUser saveAppUser = appUserRepository.save(newAppUser);
//
//        return AppUserSignUpResponse.builder()
//                .name(saveAppUser.getName())
//                .email(saveAppUser.getEmail())
//                .id(saveAppUser.getId())
//                .build();


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

//    public AppUserLoginResponse getAppUser(Long id) {
//        return Mapper.createResponseDto (appUserRepository.findById(id).orElseThrow(
//                ()->new AppUserException("Provide valid user id")));
//    }

    }

    @Override
    public AppUserResponse viewAppUser(Long id) {
        return Mapper.createResponseDto (appUserRepository.findById(id).orElseThrow(
                ()->new AppUserException("App User not Found")));
    }


    @Override
    public void deleteUser() {
        Long user_id = (Long) httpSession.getAttribute("user_id");
        boolean exists= appUserRepository.existsById(user_id);
        if(!exists){
            throw new AppUserException("user not found");
        }
        appUserRepository.deleteById(user_id);
//        return "userLogged out";


//        public void deleteUser(Long userId) {
//            if (appUserRepository.existsById(userId)) {
//                appUserRepository.deleteById(userId);
//            }
        }

}

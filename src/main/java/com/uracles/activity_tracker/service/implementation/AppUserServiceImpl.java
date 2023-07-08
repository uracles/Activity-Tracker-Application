package com.uracles.activity_tracker.service.implementation;

import com.uracles.activity_tracker.dto.request.AppUserSignUpRequest;
import com.uracles.activity_tracker.dto.response.AppUserLoginResponse;
import com.uracles.activity_tracker.dto.response.AppUserSignUpResponse;
import com.uracles.activity_tracker.entities.AppUser;
import com.uracles.activity_tracker.exception.AppUserException;
import com.uracles.activity_tracker.repository.AppUserRepository;
import com.uracles.activity_tracker.service.AppUserService;
import com.uracles.activity_tracker.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;

    @Override
    public AppUserSignUpResponse registerUser(AppUserSignUpRequest request) {

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
            throw new AppUserException(userEmail);

        return Mapper.createResponseDto(appUserRepository.save(AppUser.builder()
                .name(request.getName())
                    .email(request.getEmail())
                        .password(request.getPassword())
                             .build()
        ));


//    @Override
//    public String deleteUser() {
//        Long user_id = (Long) httpSession.getAttribute("user_id");
//        boolean exists= userRepo.existsById(user_id);
//        if(!exists){
//            throw new NotFoundException("user not found");
//        }
//        userRepo.deleteById(user_id);
//        return "userLogged out";
//    }

//    @Override
//    public AppUserLoginResponse loginUser(String email, String password){
//        AppUser appUser = appUserRepository.findByEmail(email)
//                .orElseThrow(()-> new AppUserException("User not Found OR wrong email and password"));
//        return Mapper.createResponseDto(appUser);
//
//    }

//    @Override
//    public AppUserLoginResponse getAppUser(Long id) {
//        return Mapper.createResponseDto (appUserRepository.findById(id).orElseThrow(
//                ()->new AppUserException("Provide valid user id")));
//    }
    }
}

package com.merakool.trackerApp.service.implementation;

import com.merakool.trackerApp.entity.AppUser;
import com.merakool.trackerApp.repository.AppUserRepository;
import com.merakool.trackerApp.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUser createUser(AppUser user) {
        return appUserRepository.save(user);
    }

    @Override
    public AppUser getUserById(Long userId) {
        return appUserRepository.findById(userId).orElse(null);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return appUserRepository.findByUsername(username).orElse(null);
    }
}


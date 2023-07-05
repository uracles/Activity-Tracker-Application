package com.merakool.trackerApp.service;

import com.merakool.trackerApp.entity.AppUser;

public interface AppUserService {
        AppUser createUser(AppUser user);
        AppUser getUserById(Long userId);
        AppUser getUserByUsername(String username);

}

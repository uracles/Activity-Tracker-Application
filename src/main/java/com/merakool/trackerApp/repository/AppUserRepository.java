package com.merakool.trackerApp.repository;

import com.merakool.trackerApp.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
        Optional<AppUser> findByUsername(String username);
}

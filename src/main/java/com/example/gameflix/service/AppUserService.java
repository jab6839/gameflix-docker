package com.example.gameflix.service;

import com.example.gameflix.model.AppUser;
import com.example.gameflix.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean userExists(String username) {
        return appUserRepository.findByUsername(username).isPresent();
    }

    public void saveUser(AppUser user) {
        appUserRepository.save(user);  // Password already hashed in controller
    }

    public boolean verifyUser(String username, String rawPassword) {
        Optional<AppUser> userOptional = appUserRepository.findByUsername(username);
        return userOptional.map(appUser ->
                passwordEncoder.matches(rawPassword, appUser.getPassword())
        ).orElse(false);
    }
}

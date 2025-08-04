package com.example.gameflix.service;

import com.example.gameflix.model.AppUser;
import com.example.gameflix.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); // default role
        userRepository.save(user);
    }

    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public String registerUser(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            return "Username already exists";
        }
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setPassword(password);
        saveUser(user);
        return "User registered successfully";
    }
}

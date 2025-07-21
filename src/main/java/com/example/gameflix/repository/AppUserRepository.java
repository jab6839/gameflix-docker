package com.example.gameflix.repository;

import com.example.gameflix.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    // Used in login & user loading
    Optional<AppUser> findByUsername(String username);

    // Used in registration to check duplicates
    boolean existsByUsername(String username);
}

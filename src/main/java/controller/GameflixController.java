package com.example.gameflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameflixController {

    @GetMapping("/")
    public String home() {
        return "index"; // maps to index.html
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // maps to dashboard.html
    }

    // ❌ Removed conflicting mappings
    // These are already handled by AuthController
    // @GetMapping("/login")
    // public String loginPage() {
    //     return "login";
    // }

    // @GetMapping("/register")
    // public String registerPage() {
    //     return "register";
    // }
}

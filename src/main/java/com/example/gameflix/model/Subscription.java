package com.example.gameflix.model;

import jakarta.persistence.*;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String plan;  // e.g. Basic, Premium

    public Subscription() {}

    public Subscription(String username, String plan) {
        this.username = username;
        this.plan = plan;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPlan() { return plan; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPlan(String plan) { this.plan = plan; }
}

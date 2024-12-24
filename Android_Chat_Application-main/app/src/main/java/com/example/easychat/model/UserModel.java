package com.example.easychat.model;

import com.google.firebase.Timestamp;
import java.io.Serializable;

public class UserModel implements Serializable {
    private String userId;
    private String username;
    private String email;
    private String phone;
    private String fcmToken;
    private Timestamp createdAt;

    // Default constructor required for Firebase
    public UserModel() {}

    // Constructor for all fields
    public UserModel(String userId, String username, String email, String phone, String fcmToken) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.fcmToken = fcmToken;
    }

    // New constructor to match LoginUsernameActivity usage
    public UserModel(String phone, String username, Timestamp createdAt, String userId) {
        this.phone = phone;
        this.username = username;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

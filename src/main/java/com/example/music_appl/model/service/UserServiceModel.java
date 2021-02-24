package com.example.music_appl.model.service;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserServiceModel extends BaseServiceModel{
    private String username;
    private String fullName;
    private String password;
    private String email;

    public UserServiceModel() {

    }

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotBlank(message = "Username required.")
    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "full_name", nullable = false)
    @Length(min = 3, max = 20, message = "Full name length must be between 3 and 20 characters (inclusive 3 and 20).")
    public String getFullName() {
        return fullName;
    }

    public UserServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotBlank(message = "Password required.")
    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Email(message = "Enter valid email.")
    @NotBlank(message = "Email required.")
    public String getEmail() {
        return email;
    }


    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }
}


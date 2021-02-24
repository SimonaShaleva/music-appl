package com.example.music_appl.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotBlank(message = "Username required!")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Length(min = 5, max = 20, message = "Password length must be between 5 and 20 characters (inclusive 5 and 20).")
    @NotBlank(message = "Password required.")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}

package com.recykal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//@Data
public class LoginRequest {

    @NotBlank(message = "Email is Required")
    private String email;
    @NotBlank(message = "Password is Required")
    private String password;

    public @NotBlank(message = "Email is Required") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is Required") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is Required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is Required") String password) {
        this.password = password;
    }
}

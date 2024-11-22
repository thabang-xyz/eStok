package com.novation.estok.estok.domain;

import jakarta.validation.constraints.NotBlank;

public class AuthenticationRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String email, String password) {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

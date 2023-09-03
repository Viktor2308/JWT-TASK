package com.github.viktor2308.jwttask.service;

import com.github.viktor2308.jwttask.dto.LoginRequest;
import com.github.viktor2308.jwttask.dto.JwtResponse;

import java.util.Optional;

public interface AuthService {
    Optional<JwtResponse> login(LoginRequest loginRequest);

    boolean isValid(String authHeader);
}

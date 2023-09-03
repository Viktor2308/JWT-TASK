package com.github.viktor2308.jwttask.service;

import com.github.viktor2308.jwttask.dto.LoginRequest;
import com.github.viktor2308.jwttask.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
}

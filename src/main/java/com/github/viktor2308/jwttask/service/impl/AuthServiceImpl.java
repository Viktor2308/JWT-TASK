package com.github.viktor2308.jwttask.service.impl;

import com.github.viktor2308.jwttask.dto.LoginRequest;
import com.github.viktor2308.jwttask.dto.LoginResponse;
import com.github.viktor2308.jwttask.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }
}

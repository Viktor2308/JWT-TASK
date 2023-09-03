package com.github.viktor2308.jwttask.controller;

import com.github.viktor2308.jwttask.dto.LoginRequest;
import com.github.viktor2308.jwttask.dto.LoginResponse;
import com.github.viktor2308.jwttask.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {

        return authService.login(loginRequest);
    }

}

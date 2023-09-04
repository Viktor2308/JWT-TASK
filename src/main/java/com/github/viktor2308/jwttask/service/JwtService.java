package com.github.viktor2308.jwttask.service;

public interface JwtService {
    String generateJwtToken(String username);

    String getUserNameFromJwtToken(String token);
}

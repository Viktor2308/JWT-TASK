package com.github.viktor2308.jwttask.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.viktor2308.jwttask.dto.JwtResponse;
import com.github.viktor2308.jwttask.dto.LoginRequest;
import com.github.viktor2308.jwttask.entity.User;
import com.github.viktor2308.jwttask.repository.UserRepository;
import com.github.viktor2308.jwttask.service.JwtService;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AuthServiceImplTest {
    @Autowired
    private AuthServiceImpl authServiceImpl;
    @MockBean
    private JwtService jwtService;
    @MockBean
    private UserRepository userRepository;

    @Test
    void testLogin2() {
        User user = new User();
        user.setId(1L);
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsername(Mockito.any())).thenReturn(ofResult);
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getName()).thenReturn("Name");
        when(loginRequest.getPassword()).thenReturn("iloveyou");
        assertFalse(authServiceImpl.login(loginRequest).isPresent());
        verify(userRepository).findUserByUsername(Mockito.any());
        verify(loginRequest).getName();
        verify(loginRequest).getPassword();
    }

    @Test
    void testLogin3() {
        User user = new User(1L, "janedoe", "iloveyou");
        user.setId(1L);
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsername(Mockito.any())).thenReturn(ofResult);
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getName()).thenReturn("Name");
        when(loginRequest.getPassword()).thenReturn("iloveyou");
        assertFalse(authServiceImpl.login(loginRequest).isPresent());
        verify(userRepository).findUserByUsername(Mockito.any());
        verify(loginRequest).getName();
        verify(loginRequest).getPassword();
    }

    @Test
    void testLogin5() {
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findUserByUsername(Mockito.any())).thenReturn(emptyResult);
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getName()).thenReturn("Name");
        Optional<JwtResponse> actualLoginResult = authServiceImpl.login(loginRequest);
        assertSame(emptyResult, actualLoginResult);
        assertFalse(actualLoginResult.isPresent());
        verify(userRepository).findUserByUsername(Mockito.any());
        verify(loginRequest).getName();
    }

    @Test
    void testIsValid() {
        when(jwtService.getUserNameFromJwtToken(Mockito.any())).thenReturn("janedoe");
        assertTrue(authServiceImpl.isValid("Auth Header"));
        verify(jwtService).getUserNameFromJwtToken(Mockito.any());
    }

    @Test
    void testIsValid2() {
        when(userRepository.existsByUsername(Mockito.any())).thenReturn(true);
        when(jwtService.getUserNameFromJwtToken(Mockito.any())).thenReturn("");
        assertTrue(authServiceImpl.isValid("Auth Header"));
        verify(userRepository).existsByUsername(Mockito.any());
        verify(jwtService).getUserNameFromJwtToken(Mockito.any());
    }

    @Test
    void testIsValid3() {
        when(userRepository.existsByUsername(Mockito.any())).thenReturn(false);
        when(jwtService.getUserNameFromJwtToken(Mockito.any())).thenReturn("");
        assertFalse(authServiceImpl.isValid("Auth Header"));
        verify(userRepository).existsByUsername(Mockito.any());
        verify(jwtService).getUserNameFromJwtToken(Mockito.any());
    }

}


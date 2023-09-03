package com.github.viktor2308.jwttask.controller;

import com.github.viktor2308.jwttask.dto.MessageRequest;
import com.github.viktor2308.jwttask.service.AuthService;
import com.github.viktor2308.jwttask.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final AuthService authService;

    @PostMapping("/message")
    public ResponseEntity<?> newMessage(@Valid @RequestBody MessageRequest message,
                                        @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {

        if(authHeader == null || !authHeader.startsWith("Bearer_") || !authService.isValid(authHeader)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return messageService.newMessage(message)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}

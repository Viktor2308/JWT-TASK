package com.github.viktor2308.jwttask.service;

import com.github.viktor2308.jwttask.dto.MessageRequest;
import com.github.viktor2308.jwttask.dto.MessageResponse;

import java.util.Optional;

public interface MessageService {
    Optional<MessageResponse> newMessage(MessageRequest message);
}

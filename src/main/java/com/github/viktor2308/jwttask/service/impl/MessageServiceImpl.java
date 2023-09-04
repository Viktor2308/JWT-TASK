package com.github.viktor2308.jwttask.service.impl;

import com.github.viktor2308.jwttask.dto.MessageRequest;
import com.github.viktor2308.jwttask.dto.MessageResponse;
import com.github.viktor2308.jwttask.entity.Message;
import com.github.viktor2308.jwttask.entity.User;
import com.github.viktor2308.jwttask.repository.MessageRepository;
import com.github.viktor2308.jwttask.repository.UserRepository;
import com.github.viktor2308.jwttask.service.MessageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<MessageResponse> newMessage(MessageRequest message) {
        if (message.getMessage().startsWith("history ")) {
            String stringCount = message.getMessage().substring(8);
            return getMessageHistory(Integer.parseInt(stringCount));
        }
        User currentUser = userRepository.findUserByUsername(message.getUsername()).orElseThrow(() ->
                new EntityNotFoundException("User with username: " + message.getUsername() + " not found!"));

        Message newMessage = messageRepository.save(Message.builder()
                .text(message.getMessage())
                .user(currentUser)
                .build());

        return Optional.of(
                new MessageResponse(List.of(newMessage.getText())));
    }

    private Optional<MessageResponse> getMessageHistory(int count) {
        return Optional.of(
                new MessageResponse(
                        messageRepository.findLastMessages(count)
                                .stream()
                                .map(Message::getText)
                                .toList()));
    }
}

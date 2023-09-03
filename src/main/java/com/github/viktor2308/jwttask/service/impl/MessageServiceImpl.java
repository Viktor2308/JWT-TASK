package com.github.viktor2308.jwttask.service.impl;

import com.github.viktor2308.jwttask.dto.MessageRequest;
import com.github.viktor2308.jwttask.dto.MessageResponse;
import com.github.viktor2308.jwttask.repository.MessageRepository;
import com.github.viktor2308.jwttask.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    @Override
    public Optional<MessageResponse> newMessage(MessageRequest message) {
        if(message.getMessage().startsWith("history 10")){

            return getMessageHistory();
        }

        return Optional.empty();
    }

    private Optional<MessageResponse> getMessageHistory(){
        return null;
    }
}

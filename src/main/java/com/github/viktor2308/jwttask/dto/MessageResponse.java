package com.github.viktor2308.jwttask.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class MessageResponse {
    private List<String> messages;
}

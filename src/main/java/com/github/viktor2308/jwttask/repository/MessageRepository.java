package com.github.viktor2308.jwttask.repository;

import com.github.viktor2308.jwttask.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

package com.example.demosi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class DataService {

    public Message generate() {
        log.debug("Generating message");
        return MessageBuilder.withPayload("Time : " + LocalDateTime.now()).build();
    }
}

package com.example.demosi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.history.MessageHistory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
@Slf4j
public class PrintService {

    public void print(Message message) {

        String channel = ((MessageHistory) Objects.requireNonNull(message.getHeaders().get("history"))).get(0).getProperty("name");

        UUID id = message.getHeaders().getId();
        log.info("{} : Printing : {} : {}", id, channel,  message.getPayload());
    }
}

package com.example.demosi;


import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.history.MessageHistory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Component
public class HashService {

    public void calculate(Message message) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String payload = String.valueOf(message.getPayload());
        byte[] digest = md.digest(payload.getBytes());
        String channel = ((MessageHistory) Objects.requireNonNull(message.getHeaders().get("history"))).get(0).getProperty("name");
        UUID id = message.getHeaders().getId();
        log.info("{} : Hashing  : {} : {}", id, channel,  message.getPayload());
    }
}

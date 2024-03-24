package com.packt;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(Message.class)
public class MessageManager {
    private final Message message;
    public MessageManager(Message message) {
        this.message = message;
    }

    public String message() {
        return this.message.getText();
    }
}


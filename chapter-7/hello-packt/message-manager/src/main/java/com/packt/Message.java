package com.packt;

import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties("messagemanager")
class Message {
    private String text;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
package com.packt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@SpringBootApplication(scanBasePackages = "com.packt")
@RestController
public class TimeMessageApp {
    private final MessageManager msgManager;

    public TimeMessageApp(MessageManager msgManager) {
        this.msgManager = msgManager;
    }

    public static String getCurrentDateTimeWithTimezoneAsString() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("UTC");
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss z").withZone(zoneId);
        String formattedDateTimeWithTimezone = currentDateTime
                .atZone(zoneId).format(formatter);
        return formattedDateTimeWithTimezone;
    }

    @GetMapping("/home")
    public String home() {
        return msgManager.message()
                + ". The current time is "
                + getCurrentDateTimeWithTimezoneAsString();
    }

    public static void main(String[] args) {
        SpringApplication.run(TimeMessageApp.class, args);
    }
}
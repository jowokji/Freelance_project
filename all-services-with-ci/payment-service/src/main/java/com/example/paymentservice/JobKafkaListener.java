package com.example.paymentservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class JobKafkaListener {

    @KafkaListener(topics = "jobs", groupId = "payment-group")
    public void handleJobCreated(String message) {
        System.out.println("📥 Получено сообщение из топика 'jobs': " + message);
    }
}

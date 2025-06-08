package com.example.marketplace.queue;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class LogMessageConsumer {

    private final MessageQueue messageQueue;

    public LogMessageConsumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @PostConstruct
    public void init() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    String log = messageQueue.receive("logQueue");
                    System.out.println("LOG: " + log);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}

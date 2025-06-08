package com.example.marketplace.queue;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class JobMessageConsumer {

    private final MessageQueue messageQueue;

    public JobMessageConsumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @PostConstruct
    public void init() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    String msg = messageQueue.receive();
                    System.out.println("Consumed message: " + msg);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}

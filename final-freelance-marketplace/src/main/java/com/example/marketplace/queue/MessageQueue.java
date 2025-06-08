package com.example.marketplace.queue;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Map;

@Component
public class MessageQueue {

    private final Map<String, BlockingQueue<String>> queues = new ConcurrentHashMap<>();

    public void send(String queueName, String message) {
        queues.computeIfAbsent(queueName, k -> new LinkedBlockingQueue<>()).offer(message);
    }

    public String receive(String queueName) throws InterruptedException {
        return queues.computeIfAbsent(queueName, k -> new LinkedBlockingQueue<>()).take();
    }
}

package com.example.jobservice;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Data
@Component
public class JobKafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafka;

    public void sendJobCreated(Job job) {
        kafka.send("jobs", job.toString());
        kafka.send("logs", "Job created: " + job.getId());
    }
}

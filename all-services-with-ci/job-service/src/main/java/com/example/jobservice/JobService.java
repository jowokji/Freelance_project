package com.example.jobservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository repo;
    @Autowired private JobKafkaProducer kafka;

    public List<Job> getAllJobs() {
        return repo.findAll();
    }

    public Job create(Job job) {
        Job saved = repo.save(job);
        kafka.sendJobCreated(saved);
        return saved;
    }
}

package com.example.jobservice.controller;

import com.example.jobservice.Job;
import com.example.jobservice.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping
    public List<Job> getJobs() {
        return service.getAllJobs();
    }

    @PostMapping
    public Job create(@RequestBody Job job) {
        return service.create(job);
    }
}

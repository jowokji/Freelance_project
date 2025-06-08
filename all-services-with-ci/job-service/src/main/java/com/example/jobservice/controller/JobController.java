package com.example.jobservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @GetMapping
    public List<String> getJobs() {
        return List.of("Backend Developer", "Frontend Developer");
    }
}
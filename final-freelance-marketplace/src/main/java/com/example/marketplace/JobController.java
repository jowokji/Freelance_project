package com.example.marketplace;

import com.example.marketplace.model.Job;
import com.example.marketplace.queue.MessageQueue;
import com.example.marketplace.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private MessageQueue messageQueue;

    @Autowired
    private EncryptionService encryptionService;

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        String message = "GET /jobs was called";
        String encrypted = encryptionService.encrypt(message);
        messageQueue.send("jobQueue", encrypted);
        messageQueue.send("logQueue", "User requested all jobs at " + System.currentTimeMillis());
        return jobService.getAllJobs();
    }
}

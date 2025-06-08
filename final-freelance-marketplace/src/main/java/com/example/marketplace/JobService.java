package com.example.marketplace;

import com.example.marketplace.model.Job;
import com.example.marketplace.repository.JobRepository;
import com.example.marketplace.metrics.JobMetrics;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final JobMetrics jobMetrics;

    public JobService(JobRepository jobRepository, JobMetrics jobMetrics) {
        this.jobRepository = jobRepository;
        this.jobMetrics = jobMetrics;
    }

    @Cacheable("jobs")
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public void createJob(Job job) {
        jobRepository.save(job);
        jobMetrics.incrementJobCounter();
    }
}

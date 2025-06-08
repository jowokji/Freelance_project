package com.example.marketplace;

import com.example.marketplace.model.Job;
import com.example.marketplace.repository.JobRepository;
import com.example.marketplace.metrics.JobMetrics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobServiceTest {

    @Test
    public void testGetAllJobsReturnsEmptyList() {
        JobRepository jobRepository = Mockito.mock(JobRepository.class);
        JobMetrics jobMetrics = new JobMetrics();
        Mockito.when(jobRepository.findAll()).thenReturn(Collections.emptyList());

        JobService jobService = new JobService(jobRepository, jobMetrics);
        List<Job> jobs = jobService.getAllJobs();

        assertEquals(0, jobs.size());
    }
}

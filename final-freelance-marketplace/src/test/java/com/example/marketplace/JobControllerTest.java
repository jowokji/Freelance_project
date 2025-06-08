package com.example.marketplace;

import com.example.marketplace.model.Job;
import com.example.marketplace.security.EncryptionService;
import com.example.marketplace.queue.MessageQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JobController.class)
public class JobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobService jobService;

    @MockBean
    private MessageQueue messageQueue;

    @MockBean
    private EncryptionService encryptionService;

    @Test
    public void testGetJobsReturns200() throws Exception {
        when(jobService.getAllJobs()).thenReturn(Collections.emptyList());
        when(encryptionService.encrypt("GET /jobs was called")).thenReturn("mock-encrypted");

        mockMvc.perform(get("/jobs"))
                .andExpect(status().isOk());
    }
}

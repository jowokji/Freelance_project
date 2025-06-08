package com.example.marketplace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustomMetricsController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/custom-metrics")
    public Map<String, Object> customMetrics() {
        return Map.of(
                "status", "ok",
                "uptime", System.currentTimeMillis(),
                "jobs_requested", 42
        );
    }
}

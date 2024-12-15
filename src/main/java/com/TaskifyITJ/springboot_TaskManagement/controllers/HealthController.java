package com.TaskifyITJ.springboot_TaskManagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.time.LocalDateTime;

@RestController
public class HealthController {

    // Endpoint 1 TEST
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    // Endpoint 2
    @GetMapping("/health/details")
    public Map<String, String> healthDetails() {
        return Map.of(
                "status", "UP",
                "timestamp", LocalDateTime.now().toString()
        );
    }
}
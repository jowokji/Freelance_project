package com.example.jobservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private Long employerId;

}

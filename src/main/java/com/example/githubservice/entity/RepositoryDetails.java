package com.example.githubservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
public class RepositoryDetails {
    @Id
    private String fullName;
    private String description;
    private String cloneUrl;
    private int stars;
    private LocalDate createdAt;

}
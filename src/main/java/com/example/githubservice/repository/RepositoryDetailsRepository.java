package com.example.githubservice.repository;

import com.example.githubservice.entity.RepositoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryDetailsRepository extends JpaRepository<RepositoryDetails, String> {
}

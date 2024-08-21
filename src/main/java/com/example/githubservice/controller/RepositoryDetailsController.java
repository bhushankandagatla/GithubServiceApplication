package com.example.githubservice.controller;

import com.example.githubservice.entity.RepositoryDetails;
import com.example.githubservice.service.RepositoryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepositoryDetailsController {
    @Autowired
    private RepositoryDetailsService service;

    @GetMapping("/repositories/{owner}/{repoName}")
    public RepositoryDetails getRepositoryDetails(@PathVariable String owner, @PathVariable String repoName) {
        return service.getRepositoryDetails(owner, repoName);
    }
}
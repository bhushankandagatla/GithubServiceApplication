package com.example.githubservice.service;
import com.example.githubservice.entity.RepositoryDetails;
import com.example.githubservice.repository.RepositoryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepositoryDetailsService {
    @Autowired
    private RepositoryDetailsRepository repository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "repositories", key = "#owner + '/' + #repoName")
    public RepositoryDetails getRepositoryDetails(String owner, String repoName) {
        String url = String.format("https://api.github.com/repos/%s/%s", owner, repoName);
        RestTemplate restTemplate = new RestTemplate();
        RepositoryDetails details = restTemplate.getForObject(url, RepositoryDetails.class);
        repository.save(details);
        return details;
    }
}

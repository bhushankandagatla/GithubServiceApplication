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

    @Cacheable(value = "repositories", key = "#ownerName + '/' + #repositoryName")
    public RepositoryDetails getRepositoryDetails(String ownerName, String repositoryName) {
        String url = String.format("https://api.github.com/repos/%s/%s", ownerName, repositoryName);
        RestTemplate restTemplate = new RestTemplate();
        RepositoryDetails details = restTemplate.getForObject(url, RepositoryDetails.class);
        if (details == null) throw new AssertionError();
        repository.save(details);
        return details;
    }
}

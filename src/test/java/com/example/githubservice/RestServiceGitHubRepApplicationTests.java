package com.example.githubservice;

import com.example.githubservice.entity.RepositoryDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestServiceGitHubRepApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetRepositoryDetails() {
		ResponseEntity<RepositoryDetails> response = restTemplate.getForEntity("/repositories/octocat/Hello-World", RepositoryDetails.class);
		assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
		assertThat(response.getBody()).isNotNull();
	}
}

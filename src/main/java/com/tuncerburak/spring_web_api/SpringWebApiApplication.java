package com.tuncerburak.spring_web_api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SpringWebApiApplication {

	private final TrainClient trainClient;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApiApplication.class, args);
	}

	@GetMapping(value = "/station",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login() {
		return ResponseEntity.ok(trainClient.sendRequest());
	}

}

package com.microservicesotuscourse.dockerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
public class DockerDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerDemoApplication.class, args);
    }

    @RestController
    static class HealthController {
        @GetMapping(value = "/health")
        public ResponseEntity<Map<String, String>> checkStatus() {
            return new ResponseEntity<>(Map.of("Status", "Ok"), HttpStatus.OK);
        }

    }

}

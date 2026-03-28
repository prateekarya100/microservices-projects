package com.tomcat.gatewayserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/accounts")
    public ResponseEntity<Map<String, Object>> accountsFallback(ServerHttpRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("apiPath", request.getPath().toString());
        response.put("errorCode", "SERVICE_UNAVAILABLE");
        response.put("service", "Accounts Service");
        response.put("message", "Accounts service is currently down. Please try again later.");
        response.put("errorTime", LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }

    @GetMapping("/cards")
    public ResponseEntity<Map<String, Object>> cardsFallback(ServerHttpRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("apiPath", request.getPath().toString());
        response.put("errorCode", "SERVICE_UNAVAILABLE");
        response.put("service", "Cards Service");
        response.put("message", "Cards service is temporarily unavailable.");
        response.put("errorTime", LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }

    @GetMapping("/loans")
    public ResponseEntity<Map<String, Object>> loansFallback(ServerHttpRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("apiPath", request.getPath().toString());
        response.put("errorCode", "SERVICE_UNAVAILABLE");
        response.put("service", "Loans Service");
        response.put("message", "Loans service is currently down. Please try again later.");
        response.put("errorTime", LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}

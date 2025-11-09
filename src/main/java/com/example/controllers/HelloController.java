package com.example.controllers;

import com.example.dependecyinjection.ClientComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record HelloController(ClientComponent clientComponent) {
    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/client")
    public String helloClient() {
        return "Hello from ClientComponent = " + clientComponent;
    }
}

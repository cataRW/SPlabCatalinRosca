package com.example.controllers;

import com.example.dependecyinjection.ClientComponent;
import org.springframework.web.bind.annotation.GetMapping;

public class HelloControllerTest {
    public ClientComponent clientComponent1;
    public ClientComponent clientComponent2;

    public HelloControllerTest(ClientComponent clientComponent1, ClientComponent clientComponent2) {
        this.clientComponent1 = clientComponent1;
        this.clientComponent2 = clientComponent2;
    }

    @GetMapping("/clients")
    public String clients() {
        return "clientComp1 = " + clientComponent1 + " | c2 = " + clientComponent2;
    }
}

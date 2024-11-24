package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LdapAuthenticationController {
    @GetMapping("/")
    public String index() {
        return "¡Bienvenido a la página de inicio!";
    }
}

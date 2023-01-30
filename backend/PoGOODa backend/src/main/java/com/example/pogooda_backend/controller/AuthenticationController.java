package com.example.pogooda_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @GetMapping("/auth/{userId}")
    public String getAuthenticationTokenForUser(@PathVariable Integer userId)
    {
        return null;
    }
}

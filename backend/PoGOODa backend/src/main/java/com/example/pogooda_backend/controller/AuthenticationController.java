package com.example.pogooda_backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"${client.react_address}"})
public class AuthenticationController {
    @GetMapping("/auth/{userId}")
    public String getAuthenticationTokenForUser(@PathVariable Integer userId)
    {
        return null;
    }
}

package com.datdt.AssignmentSpringboot.controller;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.datdt.AssignmentSpringboot.service.authService;
import com.datdt.AssignmentSpringboot.payload.request.LoginRequest;
import com.datdt.AssignmentSpringboot.payload.request.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/public")
public class AuthController {
    
    private final authService authService;

    @Autowired
    public AuthController(authService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request, HttpServletRequest sseRequest){
        return authService.authenticateUser(request, sseRequest);
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request){
        return authService.registerUser(request);
    }
}


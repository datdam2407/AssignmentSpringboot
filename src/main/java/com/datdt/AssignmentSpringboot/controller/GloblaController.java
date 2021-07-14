package com.datdt.AssignmentSpringboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/public")
public class GloblaController {
    public String welcomePage(){
        return "index";
    }
}


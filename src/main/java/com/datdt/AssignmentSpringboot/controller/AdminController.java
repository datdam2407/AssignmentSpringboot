// package com.datdt.AssignmentSpringboot.controller;

// import com.datdt.AssignmentSpringboot.entity.AccountAdmin;
// import com.datdt.AssignmentSpringboot.service.authService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// @CrossOrigin(origins = "*", maxAge = 3600)
// public class AdminController {
//     private final authService authService;

//     @Autowired
//     public AdminController(com.datdt.AssignmentSpringboot.service.authService authService) {
//         this.authService = authService;
//     }
//     @PostMapping()
//     ResponseEntity<?> addNewAdmin(@RequestBody AccountAdmin accountAdmin){
//         return authService.registerUser(accountAdmin);
//     }
// }

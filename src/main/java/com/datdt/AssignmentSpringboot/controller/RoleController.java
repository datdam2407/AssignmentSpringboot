package com.datdt.AssignmentSpringboot.controller;

import com.datdt.AssignmentSpringboot.entity.Role;
import com.datdt.AssignmentSpringboot.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
@SpringBootTest
public class RoleController {
    private final RoleService roleService;
    
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_MANAGER')")
    public String userAccess() {
        return "Welcome!!!";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public String managerAccess() {
        return "Hi MANAGER";
    }
    
    @PostMapping("/manager/roles")
    public Role createRole(Role newAdmin){
        return roleService.createRole(newAdmin);
    }
}


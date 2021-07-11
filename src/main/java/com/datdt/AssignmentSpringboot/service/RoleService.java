package com.datdt.AssignmentSpringboot.service;

import java.util.List;

import com.datdt.AssignmentSpringboot.entity.Role;
import com.datdt.AssignmentSpringboot.exception.ExistException;
import com.datdt.AssignmentSpringboot.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles(){
        return (List<Role>) this.roleRepository.findAll();
    }

    public Role createRole(Role newRole){
        roleRepository.findByName(newRole.getRoleName()).orElseThrow(() 
        -> new ExistException(newRole.getRoleName()));
        return this.roleRepository.save(newRole);
    }
}

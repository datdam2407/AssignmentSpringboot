package com.datdt.AssignmentSpringboot.repository;

import java.util.Optional;
import com.datdt.AssignmentSpringboot.entity.Role;
import com.datdt.AssignmentSpringboot.entity.RoleName;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    Optional<Role> findByName(RoleName roleName);
}
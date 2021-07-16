package com.datdt.AssignmentSpringboot.test.serviceTest;

import java.util.ArrayList;
// import java.util.Date;
import java.util.List;
// import java.util.Map;
// import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.datdt.AssignmentSpringboot.entity.Role;
import com.datdt.AssignmentSpringboot.entity.RoleName;
import com.datdt.AssignmentSpringboot.repository.RoleRepository;
import com.datdt.AssignmentSpringboot.service.RoleService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class RoleServiceTest {
    @Autowired
    private RoleService roleService;
    @MockBean
    private RoleRepository roleRepository;
    @MockBean
    Role Role;
    public static final Long ID = 1L;
    
    List<Role> list;

    @BeforeEach
    public void setUpRole() {
        list = new ArrayList<>();

        Role role = new Role(1L, RoleName.ROLE_CUSTOMER);
        Role role2 = new Role(2L, RoleName.ROLE_MANAGER);
        Role role3 = new Role(3L, RoleName.ROLE_CUSTOMER);
        list.add(role);
        list.add(role2);
        list.add(role3);
    }

    @Test
    public void getAllTest_returnRoleList() throws Exception {
        when(roleRepository.findAll()).thenReturn(list);
        assertEquals(roleService.getAllRoles(), list);
        verify(roleRepository, times(1)).findAll();
    }

    // @Test
    // public void createRole_ThenReturnRole() throws Exception {
    //     when(roleRepository.save(list.get)).thenReturn(list.get(0));
    //     assertEquals(roleService.createRole(list.get(0)), list.get(0));
    
    // }
}
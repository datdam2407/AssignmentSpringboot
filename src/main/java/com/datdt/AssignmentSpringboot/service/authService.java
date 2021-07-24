package com.datdt.AssignmentSpringboot.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.datdt.AssignmentSpringboot.repository.AccountRepository;
import com.datdt.AssignmentSpringboot.repository.RoleRepository;
import com.datdt.AssignmentSpringboot.sercurity.jwt.JwtUtils;
import com.datdt.AssignmentSpringboot.sercurity.service.accountDetailImpl;
import com.datdt.AssignmentSpringboot.entity.Account;
// import com.datdt.AssignmentSpringboot.entity.AccountAdmin;
import com.datdt.AssignmentSpringboot.entity.Role;
import com.datdt.AssignmentSpringboot.entity.RoleName;
import com.datdt.AssignmentSpringboot.payload.request.LoginRequest;
import com.datdt.AssignmentSpringboot.payload.request.RegisterRequest;
import com.datdt.AssignmentSpringboot.payload.response.JWTResponse;
import com.datdt.AssignmentSpringboot.payload.response.MessageResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class authService {
    
    private final AuthenticationManager authenticationManager;
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    public authService(AuthenticationManager authenticationManager,
                        AccountRepository accountRepository,
                        RoleRepository roleRepository, PasswordEncoder encoder,
                        JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }
  

    public ResponseEntity<?> authenticateUser(LoginRequest request,
     HttpServletRequest sseRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), 
            request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtUtils.generateJwtToken(authentication);

        accountDetailImpl userDetails = (accountDetailImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());



        sseRequest.getSession().setAttribute("currentUsername", request.getUsername());
        return ResponseEntity.ok(new JWTResponse(jwt,
                                                 userDetails.getId(),
                                                 userDetails.getUsername(),
                                                 userDetails.getEmail(),
                                                 roles));
    }

    public ResponseEntity<?> registerUser(RegisterRequest request) {
        if (accountRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (accountRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Account account = new Account(request.getUsername(), 
                                      request.getFullName(), 
                                      encoder.encode(request.getPassword()), 
                                      request.getEmail(), 
                                      request.getPhone(), 
                                      request.getAddress(), 
                                      request.getStatus(), 
                                      new Date());

        Set<String> strRoles = request.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleName.ROLE_CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role.toLowerCase()) {
                    
                    case "ROLE_MANAGER":
                        Role modRole = roleRepository.findByName(RoleName.ROLE_MANAGER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(RoleName.ROLE_CUSTOMER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        account.setRole(roles);
        account.setStatus("accpeted");
        accountRepository.save(account);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
 
   
}
package com.datdt.AssignmentSpringboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_accountAdmin")
public class AccountAdmin implements Serializable{
    @Id
    @Column(name = "email" , nullable = false, unique = true)
    private String email;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "role")
    private String role;    
    public AccountAdmin() {
        super();
    }
    public AccountAdmin(String email, String fullname, String password, String role) {
        super();
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
}

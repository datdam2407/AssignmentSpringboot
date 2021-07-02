package com.datdt.AssignmentSpringboot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Account")
public class Account implements Serializable{
  
	@Id
    @Column(name = "email" , nullable = false, unique = true)
    private String email;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "status")
    private String status;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> order;
    
    
    public Account() {
        super();
    }
    public Account(String email, String fullname, String password, String role) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }
    public Account(String email, String fullname, String password, String role, String status, String address,
            String phone, Date createDate) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.createDate = createDate;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
  
    
}

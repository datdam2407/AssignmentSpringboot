package com.datdt.AssignmentSpringboot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "tbl_account", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "email"
    }),
    @UniqueConstraint(columnNames = {
        "username"
    })
})
public class Account implements Serializable{
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long userId;
    
    @NotEmpty
    @Size(max = 50, message = "username must be filled and have at least 6 characters")
    @Column(name = "username")
    private String username;

    @Email
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email" , nullable = false, unique = true)
    private String email;
    
    @NotEmpty
    @Size(max = 30, message = "Full name must be filled")
    @Column(name = "fullname")
    private String fullname;

    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "status")
    private String status;
    
    @NotEmpty
    @Size(max = 150, message = "Address must be filled")
    @Column(name = "address")
    private String address;

    @NotEmpty
    @Size(max = 10, message = "Phone must be filled and have 10 numbers")
    @Column(name = "phone")
    private String phone;
    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> order;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();
    
    public Account() {
        super();
    }
    public Account(String email, String fullname, String password, String role) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
    }
    public Account(String username, String fullname, String password, String email, String status, String address,
            String phone, Date createDate) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
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
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Set<Role> getRole() {
        return role;
    }
    public void setRole(Set<Role> role) {
        this.role = role;
    }
    
    
  
    
}

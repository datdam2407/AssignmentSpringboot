// package com.datdt.AssignmentSpringboot.entity;

// import java.io.Serializable;
// import java.util.HashSet;
// import java.util.Set;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
// import javax.persistence.Table;
// import javax.persistence.JoinColumn;


// @Entity
// @Table(name = "tbl_accountAdmin")
// public class AccountAdmin implements Serializable{
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY) 
//     private long adminId;
//     @Column(name = "username")
//     private String username;
//     @Column(name = "fullname")
//     private String fullname;
//     @Column(name = "password", nullable = false)
//     private String password;
      
//     @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "account_roles",
//             joinColumns = @JoinColumn(name = "admin_id"),
//             inverseJoinColumns = @JoinColumn(name = "role_id"))
//     private Set<Role> role = new HashSet<>();

   

//     public AccountAdmin() {
//         super();
//     }
//     public AccountAdmin(String fullname, String password) {
//         super();
//         this.fullname = fullname;
//         this.password = password;
//     }
//     public String getFullname() {
//         return fullname;
//     }
//     public void setFullname(String fullname) {
//         this.fullname = fullname;
//     }
//     public String getPassword() {
//         return password;
//     }
//     public void setPassword(String password) {
//         this.password = password;
//     }
    
    
// }

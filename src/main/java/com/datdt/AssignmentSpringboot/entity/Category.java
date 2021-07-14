package com.datdt.AssignmentSpringboot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "tbl_category")
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryID;
    
    @NotBlank(message = "Hey input category's name....")
    @Column(name = "category_name")
    private String categoryName;

    @NotBlank(message = "Should be inputed category's description....")
    @Column(name = "category_description")
    private String categoryDescription;
    
        @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
       @Transient
        private List<Product> products = new ArrayList<>();
        public Category() {
        super();
    }
    public Category(long categoryID,  String categoryName,
             String categoryDescription) {
        super();
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }
    
    public Category(String categoryName, String categoryDescription) {       
        super();
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }
    public long getCategoryID() {
        return categoryID;
    }
    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryDescription() {
        return categoryDescription;
    }
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
}

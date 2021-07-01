package com.datdt.AssignmentSpringboot.entity;

import java.io.Serializable;
import java.util.Date;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_product")

public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "product_Discription")
    private String productDiscription;
    
    @Column(name = "create_Date")
    private Date createDate;
    
    @Column(name = "updated_Date")
    private Date updateDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_ID")  
    
    private Category category ;

    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private Set<OrderDetail> OrderDetail;

    @Column(name = "product_Price")
    private float productPrice;
    
    @Column(name = "product_Status")
    private String productStatus;
    
    @Column(name = "product_Image")
    private String productImage;
    
    @Column(name = "product_Quantity")
    private int productQuantity;
    public Product() {
        super();
    }
    
    public Product(Long productID, String productName, String productDiscription, Date createDate, Date updateDate,
            float productPrice, String productStatus, String productImage, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productDiscription = productDiscription;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
    }

    public Long getProductID() {
        return productID;
    }
    public void setProductID(Long productID) {
        this.productID = productID;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDiscription() {
        return productDiscription;
    }
    public void setProductDiscription(String productDiscription) {
        this.productDiscription = productDiscription;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public float getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductStatus() {
        return productStatus;
    }
    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
    public String getProductImage() {
        return productImage;
    }
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
   
    
}

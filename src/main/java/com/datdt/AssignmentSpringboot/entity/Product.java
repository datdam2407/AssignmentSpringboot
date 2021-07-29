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
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "tbl_product")

public class Product implements Serializable{
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productID;

    
    @NotBlank(message = "Name of product must be filled!!")
    @Column(name = "product_name")
    private String productName;
    
    @NotBlank(message = "Discription must be filled must be filled....")
    @Column(name = "product_discription")
    private String productDiscription;
  
    @Column(name = "create_date")
    private Date createDate;
    
    @Column(name = "updated_date")
    private Date updateDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")  
    
    private Category category ;

    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private Set<OrderDetail> OrderDetail;
    @NotNull(message = "Price of product must be filled!!")
    @Positive
    @Column(name = "product_price")
    private float productPrice;
    
    @Column(name = "product_status")
    private String productStatus;
    
    
    @Transient
    private int cartQuantity;
     
    @NotBlank(message = "Should be inputed link image !!!")
    @Column(name = "product_image")
    private String productImage;
    
    @NotNull(message = "Quantity of product must be filled!!")
    @Positive
    @Column(name = "product_quantity")
    private int productQuantity;
    public Product() {
        super();
    }

    public Product(String productName, String productDiscription, Date createDate, Date updateDate,
            float productPrice, String productStatus, String productImage, int productQuantity) {
        super();

        this.productName = productName;
        this.productDiscription = productDiscription;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
    }

    public long getProductID() {
        return productID;
    }
    public void setProductID(long productID) {
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

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
   
    
}

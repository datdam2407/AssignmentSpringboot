package com.datdt.AssignmentSpringboot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OrderID;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "total_price")
    private float totalPrice;
  
    @NotBlank(message = "Input your name please....")
    @Column(name = "customer_name")
    private String customerName;

    @NotBlank(message = "Input your phone please....")
    @Column(name = "customer_phone")
    private String customerPhone;

    @NotBlank(message = "Input your address please....")
    @Column(name = "customer_address")
    private String customerAddress;
    
    @Column(name = "status")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_status",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id"))
    private Set<StatusOrder> status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Account account;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetail;

  
    public Order() {
        super();
    }

    public Order(Date createDate, float totalPrice, String customerName, String customerPhone,
            String customerAddress) {
        this.createDate = createDate;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
    }

    public long getOrderID() {
        return OrderID;
    }

    public void setOrderID(long orderID) {
        OrderID = orderID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Set<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public void setStatus(Set<StatusOrder> status) {
        this.status = status;
    }

    public Set<StatusOrder> getStatus() {
        return status;
    }

}

package com.datdt.AssignmentSpringboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_OrderDetail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderDetailID;
    @Column(name = "feedback_content")
    private String feedbackContent;
    @Column(name = "rateStar")
    private int rateStar;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetail() {
        super();
    }
    
    public OrderDetail(long orderDetailID, String feedbackContent, int rateStar) {
        this.orderDetailID = orderDetailID;
        this.feedbackContent = feedbackContent;
        this.rateStar = rateStar;
    }

    public long getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(long orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public int getRateStar() {
        return rateStar;
    }

    public void setRateStar(int rateStar) {
        this.rateStar = rateStar;
    }

   
}

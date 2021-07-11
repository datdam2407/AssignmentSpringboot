package com.datdt.AssignmentSpringboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name = "tbl_rate")
@Entity

public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rateID;

    @ManyToOne
    @JoinColumn(name = "username")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    @Column(name = "numOfStar")
    private Integer numOfStar;

    @Column(name = "description")
    private String description;

    @Column(name = "dateRate")
    private Date dateRate;

}


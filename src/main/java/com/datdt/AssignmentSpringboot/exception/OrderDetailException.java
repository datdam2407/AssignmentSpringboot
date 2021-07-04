package com.datdt.AssignmentSpringboot.exception;

public class OrderDetailException extends RuntimeException {
    public OrderDetailException(Long ID){
         super("Could Not Find OrderDetail ");
    } 
}


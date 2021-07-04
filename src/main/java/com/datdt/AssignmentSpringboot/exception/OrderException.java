package com.datdt.AssignmentSpringboot.exception;

public class OrderException extends RuntimeException {
        public OrderException(Long orderID){
            super("Could Not Find Order "+ orderID);
        } 
}



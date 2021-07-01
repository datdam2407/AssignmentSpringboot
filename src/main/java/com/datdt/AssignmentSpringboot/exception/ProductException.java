package com.datdt.AssignmentSpringboot.exception;

public class ProductException extends RuntimeException {
    public ProductException(Long productID) {
        super("Could Not Find Product " + productID);
    }

}

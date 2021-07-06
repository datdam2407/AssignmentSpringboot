package com.datdt.AssignmentSpringboot.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long ID){
        super("Could Not Find OrderDetail ");
    } 
   
}


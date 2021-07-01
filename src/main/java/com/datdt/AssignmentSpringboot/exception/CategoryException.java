package com.datdt.AssignmentSpringboot.exception;


public class CategoryException extends RuntimeException {
    public CategoryException(Long categoryID){
        super("Could Not Find Category "+ categoryID);
    } 
    
}



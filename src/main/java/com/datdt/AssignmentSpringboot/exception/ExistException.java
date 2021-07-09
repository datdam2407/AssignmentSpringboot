package com.datdt.AssignmentSpringboot.exception;

import com.datdt.AssignmentSpringboot.entity.RoleName;

public class ExistException extends RuntimeException{
    public ExistException(RoleName roleName){
        super("Role With This Name Already Exist: "+ roleName);
    }
}

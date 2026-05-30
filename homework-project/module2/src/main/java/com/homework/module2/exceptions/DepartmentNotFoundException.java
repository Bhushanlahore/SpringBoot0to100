package com.homework.module2.exceptions;

public class DepartmentNotFoundException extends  RuntimeException{

    public DepartmentNotFoundException(String msg){
        super(msg);
    }

}

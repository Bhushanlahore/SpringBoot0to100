package com.module3.cms.exception;

public class StudentNotFoundException extends RuntimeException{

    public  StudentNotFoundException(String msg){
        super(msg);
    }
}

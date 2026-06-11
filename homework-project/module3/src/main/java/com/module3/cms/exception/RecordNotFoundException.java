package com.module3.cms.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String msg){
        super(msg);
    }
}

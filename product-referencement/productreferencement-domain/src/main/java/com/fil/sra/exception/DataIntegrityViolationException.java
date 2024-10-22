package com.fil.sra.exception;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String msg){
        super(msg);
    }

}

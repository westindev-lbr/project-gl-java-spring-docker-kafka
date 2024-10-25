package com.fil.sra.exception;

public class NotEnoughStockQuantityException extends RuntimeException{
    public NotEnoughStockQuantityException(String msg){
        super(msg);
    }

}

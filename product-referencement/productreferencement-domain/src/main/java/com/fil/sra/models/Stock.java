package com.fil.sra.models;

import com.fil.sra.exception.NotEnoughStockQuantityException;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Stock {
    protected int id;
    protected Product product;
    protected int quantity;

    public void increaseQuantity(int amount){
        this.setQuantity(this.getQuantity()+amount);
    }

    public void decreaseQuantity(int amount) throws NotEnoughStockQuantityException{
        if(this.quantity - amount < 0)
            throw new NotEnoughStockQuantityException("Cannot decrease stock quantity when there is not enough quantity");
        this.setQuantity(this.getQuantity()-amount);
    }

    public void putBackInStock(){
        // TODO : Should we set this method "Abstract" first ?
    }
}

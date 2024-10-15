package com.fil.sra.models;

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

    public void decreaseQuantity(int amount){
        this.setQuantity(this.getQuantity()-amount);
    }

    public void putBackInStock(){
        // TODO : Should we set this method "Abstract" first ?
    }
}

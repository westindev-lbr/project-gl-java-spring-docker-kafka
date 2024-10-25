package com.fil.sra.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
public class PerishableStock extends Stock{
    private Date bestBefore;
    private String lot;
    private Perishable perishable;

    @Override
    public void putBackInStock() {
        //TODO : to implement...
    }
}

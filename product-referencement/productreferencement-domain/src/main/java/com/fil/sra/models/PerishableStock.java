package com.fil.sra.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
public class PerishableStock extends Stock{
    public Date bestBefore;
    public String lot;
    @Override
    public void putBackInStock() {
        //TODO : to implement...
    }
}

package com.fil.sra.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ProductStock extends Stock{
    @Override
    public void putBackInStock() {
        //TODO : to implement...
    }
}

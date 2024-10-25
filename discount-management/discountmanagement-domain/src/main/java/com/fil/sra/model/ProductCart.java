package com.fil.sra.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductCart {
    private int id;
    private String ean;
    private String name;
    private int quantity; 
    private double amount;
    private Cart cart;
}
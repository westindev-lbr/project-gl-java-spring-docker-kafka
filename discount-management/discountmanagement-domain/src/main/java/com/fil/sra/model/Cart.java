package com.fil.sra.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Cart {
    private int id;
    private int clientId;
    private List<ProductCart> productsCart;
    List<MarketOperation> marketOperations;
    private double amount;
}

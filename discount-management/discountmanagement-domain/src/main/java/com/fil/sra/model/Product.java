package com.fil.sra.model;

import lombok.*;

@Getter
@Setter
@Builder
public class Product {

    private int actualPrice;

    private int originalPrice;

    private String name;
}

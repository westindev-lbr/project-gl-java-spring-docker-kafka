package com.fil.sra.model;

import lombok.*;

@Getter
@Setter
@Builder
public class Product {

    private double actualPrice;

    private double originalPrice;

    private String ean;
}

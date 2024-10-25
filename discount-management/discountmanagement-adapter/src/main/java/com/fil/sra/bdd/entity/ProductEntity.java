package com.fil.sra.bdd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductEntity {

    private int id;

    private double actualPrice;

    private double originalPrice;

    private String ean;

}

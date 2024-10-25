package com.fil.sra.bdd.entity;

import com.fil.sra.model.MarketOperation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_discounted")
public class ProductDiscountedEntity {

    @ManyToOne
    @MapsId
    @JoinColumn(name = "marketOperation.id", nullable = false)
    private MarketOperationEntity marketOperation;

    @Id
    public int productId;

    public double actualPrice;

    public double originalPrice;

    public String ean;
}

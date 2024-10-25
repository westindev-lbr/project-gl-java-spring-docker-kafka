package com.fil.sra.bdd.entity;

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
@IdClass(CompositeKey.class)
public class ProductDiscountedEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "market_operation_id", nullable = false)
    public int marketOperationId;

    @Id
    public int productId;

    public double actualPrice;

    public double originalPrice;

    public String ean;
}

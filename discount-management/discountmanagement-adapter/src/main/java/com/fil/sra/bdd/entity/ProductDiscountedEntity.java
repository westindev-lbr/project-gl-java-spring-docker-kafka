package com.fil.sra.bdd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
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
    public int marketOperationId;

    @Id
    public int productId;

    public int actualPrice;
}

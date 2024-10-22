package com.fil.sra.bdd.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class MarketOperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String name;

    protected Date startDate;

    protected Date endDate;

    protected List<ProductEntity> products;

    protected TypeOfMarketOperationEntity type;

}

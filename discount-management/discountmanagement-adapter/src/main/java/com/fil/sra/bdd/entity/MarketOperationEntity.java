package com.fil.sra.bdd.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public abstract class MarketOperationEntity {

    protected Integer id;

    protected String name;

    protected Date startDate;

    protected Date endDate;

    protected List<ProductEntity> products;

    protected TypeOfMarketOperationEntity type;

}

package com.fil.sra.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public abstract class MarketOperationEntity {

    protected String name;

    protected Date startDate;

    protected Date endDate;

    protected List<ProductEntity> products;

    protected TypeOfMarketOperationEntity type;

    protected abstract int applyDiscount();

}

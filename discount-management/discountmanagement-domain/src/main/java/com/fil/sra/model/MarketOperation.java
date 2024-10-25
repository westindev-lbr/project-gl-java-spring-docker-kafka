package com.fil.sra.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@SuperBuilder
public abstract class MarketOperation {

    protected int id;

    protected Date startDate;

    protected Date endDate;

    protected List<ProductDiscounted> products;

    protected TypeMarketOperation type;

    protected abstract int applyDiscount();
}

package com.fil.sra.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public abstract class MarketOperation {

    protected String name;

    protected Date startDate;

    protected Date endDate;

    protected List<Product> products;

    protected TypeMarketOperation type;

    protected abstract int applyDiscount();
}

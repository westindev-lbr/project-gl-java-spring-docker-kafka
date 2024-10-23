package com.fil.sra.model;

import lombok.*;
import lombok.experimental.SuperBuilder;



@SuperBuilder
@Getter
@Setter
public class MarketOperationDefault extends MarketOperation{

    protected double discounted_value;

    protected boolean isPercent;

    protected int applyDiscount() {
        return 0;
    }
}

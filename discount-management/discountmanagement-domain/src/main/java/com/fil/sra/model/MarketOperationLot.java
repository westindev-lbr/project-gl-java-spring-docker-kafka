package com.fil.sra.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MarketOperationLot extends MarketOperation{

    protected int numberForLot;

    protected double priceForLot;

    @Override
    protected int applyDiscount() {
        return 0;
    }
}

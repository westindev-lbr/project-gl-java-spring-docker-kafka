package com.fil.sra.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class MarketOperationLot extends MarketOperation{

    protected int numberForLot;

    protected double priceForLot;

    public int applyDiscount() {
        return 0;
    }
}

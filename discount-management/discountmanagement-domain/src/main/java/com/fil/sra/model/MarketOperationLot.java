package com.fil.sra.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
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

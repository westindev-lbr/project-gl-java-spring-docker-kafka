package com.fil.sra.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MarketOperationLeastPricey extends MarketOperation {

    protected int valueOrPercentReduction;

    protected int applyDiscount() {
        return 0;
    }
}

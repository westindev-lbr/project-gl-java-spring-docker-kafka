package com.fil.sra.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MarketOperationLeastPricey extends MarketOperation {

    protected int valueOrPercentReduction;

    protected int applyDiscount() {
        return 0;
    }
}

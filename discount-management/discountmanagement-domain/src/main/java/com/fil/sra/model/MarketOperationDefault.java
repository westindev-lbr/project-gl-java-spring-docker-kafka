package com.fil.sra.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MarketOperationDefault extends MarketOperation{

    protected double value;

    protected boolean isPercent;

    @Override
    protected int applyDiscount() {
        return 0;
    }
}

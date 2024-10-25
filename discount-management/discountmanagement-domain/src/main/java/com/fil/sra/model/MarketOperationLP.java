package com.fil.sra.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class MarketOperationLP extends MarketOperationDefault {

    protected int applyDiscount() {
        return 0;
    }
}

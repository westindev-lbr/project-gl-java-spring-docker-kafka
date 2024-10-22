package com.fil.sra.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MarketOperationDefaultEntity extends MarketOperationEntity{

    protected double value;

    protected boolean isPercent;

    protected int applyDiscount() {
        return 0;
    }
}

package com.fil.sra.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MarketOperationLeastPriceyEntity extends MarketOperationEntity {

    protected int valueOrPercentReduction;

    protected int applyDiscount() {
        return 0;
    }
}

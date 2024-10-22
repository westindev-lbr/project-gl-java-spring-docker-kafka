package com.fil.sra.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MarketOperationCode extends MarketOperationEntity{

    protected int applyDiscount() {
        return 0;
    }
}

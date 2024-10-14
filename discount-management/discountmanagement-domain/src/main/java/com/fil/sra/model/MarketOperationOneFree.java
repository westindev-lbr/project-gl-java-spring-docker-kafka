package com.fil.sra.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MarketOperationOneFree extends MarketOperation{

    protected int numberForOneFree;

    protected int applyDiscount() {
        return 0;
    }
}

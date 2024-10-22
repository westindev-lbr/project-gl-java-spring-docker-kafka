package com.fil.sra.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class MarketOperationOneFree extends MarketOperation{

    protected int numberForOneFree;

    protected int applyDiscount() {
        return 0;
    }
}

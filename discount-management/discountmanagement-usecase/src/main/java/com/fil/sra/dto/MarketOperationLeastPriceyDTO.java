package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MarketOperationLeastPriceyDTO extends MarketOperationDTO{

    protected int valueOrPercentReduction;

    protected int applyDiscount() {
        return 0;
    }

}

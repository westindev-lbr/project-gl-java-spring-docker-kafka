package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MarketOperationDefaultDTO extends MarketOperationDTO{

    protected double value;

    protected boolean isPercent;

    protected int applyDiscount() {
        return 0;
    }
}

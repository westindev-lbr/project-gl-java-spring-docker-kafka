package com.fil.sra.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class MarketOperationDefaultDTO extends MarketOperationDTO{

    protected double value;

    protected boolean isPercent;
}

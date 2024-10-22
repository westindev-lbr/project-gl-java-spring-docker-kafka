package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class MarketOperationLeastPriceyDTO extends MarketOperationDTO{

    protected int valueOrPercentReduction;

}

package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MarketOperationLotDTO extends MarketOperationDTO{

    protected int numberForLot;

    protected double priceForLot;

}

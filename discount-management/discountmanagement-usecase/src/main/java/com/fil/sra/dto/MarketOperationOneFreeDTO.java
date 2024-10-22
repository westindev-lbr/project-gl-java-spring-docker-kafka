package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class MarketOperationOneFreeDTO extends MarketOperationDTO{

    protected int numberForOneFree;

}

package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MarketOperationOneFreeDTO extends MarketOperationDTO{

    protected int numberForOneFree;

}

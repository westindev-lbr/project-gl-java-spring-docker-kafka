package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MarketOperationCodeDTO extends MarketOperationDTO{

    protected String code;

}

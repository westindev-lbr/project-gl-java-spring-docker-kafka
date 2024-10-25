package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class MarketOperationCodeDTO extends MarketOperationDefaultDTO{

    protected String code;

}

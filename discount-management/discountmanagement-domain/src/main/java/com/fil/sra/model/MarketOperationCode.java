package com.fil.sra.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MarketOperationCode extends MarketOperationDefault{

    protected String code;

    @Override
    protected int applyDiscount(){
        return 1;
    }

}

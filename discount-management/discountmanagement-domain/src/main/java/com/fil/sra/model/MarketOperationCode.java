package com.fil.sra.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class MarketOperationCode extends MarketOperationDefault{

    protected String code;

    protected int applyDiscount(){
        return super.applyDiscount();
    }

}

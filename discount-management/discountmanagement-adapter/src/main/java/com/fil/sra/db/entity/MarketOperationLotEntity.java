package com.fil.sra.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MarketOperationLotEntity extends MarketOperationEntity{

    protected int numberForLot;

    protected double priceForLot;

}

package com.fil.sra.bdd.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MarketOperationDefaultEntity extends MarketOperationEntity{

    protected double value;

    protected boolean isPercent;

}

package com.fil.sra.bdd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class MarketOperationDefaultEntity extends MarketOperationEntity{

    protected double discounted_value;

    protected boolean isPercent;

}

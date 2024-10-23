package com.fil.sra.bdd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class MarketOperationCodeEntity extends MarketOperationDefaultEntity{

    private String code;

}

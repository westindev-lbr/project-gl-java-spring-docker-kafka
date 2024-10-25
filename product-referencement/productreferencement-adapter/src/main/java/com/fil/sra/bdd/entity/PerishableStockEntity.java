package com.fil.sra.bdd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "perishable_stock")
public class PerishableStockEntity extends StockEntity{

    @Temporal(TemporalType.DATE)
    private Date bestBefore;
    private String lot;
    @OneToOne
    private PerishableEntity perishable;
}

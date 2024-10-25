package com.fil.sra.bdd.entity;

import com.fil.sra.models.PerishableStock;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "perishable")
public class PerishableEntity extends ArticleEntity{
    @Temporal(TemporalType.DATE)
    private Date bestBefore;
    private String lot;
    @OneToOne(
            cascade = CascadeType.ALL, orphanRemoval = true
    )
    private PerishableStockEntity perishableStock;
}

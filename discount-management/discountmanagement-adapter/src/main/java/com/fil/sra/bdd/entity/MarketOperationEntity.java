package com.fil.sra.bdd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "market_operation")
public abstract class MarketOperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Integer id;

    protected String name;

    protected Date startDate;

    protected Date endDate;

    @OneToMany(mappedBy = "marketOperation", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<ProductDiscountedEntity> products;

    @Enumerated(EnumType.ORDINAL)
    protected TypeOfMarketOperationEntity type;

}

package com.fil.sra.bdd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "perishable")
public class PerishableEntity extends ArticleEntity {

    @Temporal(TemporalType.DATE)
    private Date bestBefore;

    @ManyToOne
    private ArticleEntity article;
    private String lot;

}

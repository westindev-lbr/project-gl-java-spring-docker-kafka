package com.fil.sra.bdd.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.experimental.SuperBuilder;
import java.util.Date;

@Entity
@SuperBuilder
public class PerishableEntity extends ArticleEntity {
    @Temporal(TemporalType.DATE)
    private Date bestBefore;
    public PerishableEntity() {
        super();
    }
}

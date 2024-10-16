package com.fil.sra.bdd.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PerishableEntity extends ArticleEntity {
    @Temporal(TemporalType.DATE)
    private Date bestBefore;


}

package com.fil.sra.bdd.entity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Entity
@Getter
@Setter
@SuperBuilder
public class ProductEntity extends ArticleEntity{
    public ProductEntity() {
        super();
    }
}

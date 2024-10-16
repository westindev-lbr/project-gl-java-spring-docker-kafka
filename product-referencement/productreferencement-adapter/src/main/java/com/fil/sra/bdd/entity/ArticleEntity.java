package com.fil.sra.bdd.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.List;

@SuperBuilder
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class ArticleEntity {
    public ArticleEntity(){

    }
    protected String img;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String ean;
    @ManyToMany
    protected List<CategoryEntity> categories;
    protected Double price;
    protected Float vat;
    protected String name;
    private String brand;
}

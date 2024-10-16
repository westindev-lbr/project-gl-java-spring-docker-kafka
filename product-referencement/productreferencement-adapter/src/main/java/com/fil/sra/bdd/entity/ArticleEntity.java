package com.fil.sra.bdd.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.List;


@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Entity
public class ArticleEntity {

    protected String img;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String ean;

    @ManyToMany(fetch = FetchType.EAGER)
    protected List<CategoryEntity> categories;
    protected Double price;
    protected Float vat;
    protected String name;
    private String brand;
}

package com.fil.sra.bdd.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Entity(name = "article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String name;
    protected String brand;
    protected Double price;
    protected String ean;
    protected Float vat;
    protected String img;

    @ManyToMany(fetch = FetchType.EAGER)
    protected List<CategoryEntity> categories;

    @OneToOne(mappedBy = "article",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true
    )
    protected StockEntity stockGlobal;
}

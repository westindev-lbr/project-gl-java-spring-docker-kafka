package com.fil.sra.bdd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "stock")
@Inheritance(strategy = InheritanceType.JOINED)
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    protected int quantity;

    @OneToOne
    @JoinColumn(name = "article_id", nullable = true)
    protected ArticleEntity article;

    public StockEntity(ArticleEntity article, int quantity) {
        this.quantity = quantity;
        this.article = article;
    }

}

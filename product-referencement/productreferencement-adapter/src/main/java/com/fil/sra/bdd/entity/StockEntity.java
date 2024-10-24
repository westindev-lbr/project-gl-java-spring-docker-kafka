package com.fil.sra.bdd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "stock")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int quantity;

    @OneToOne
    @JoinColumn(name = "article_id", nullable = false)
    private ArticleEntity article;

    public StockEntity(ArticleEntity article, int quantity) {
        this.quantity = quantity;
        this.article = article;
    }

}

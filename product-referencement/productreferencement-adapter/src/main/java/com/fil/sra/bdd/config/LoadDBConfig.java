package com.fil.sra.bdd.config;

import com.fil.sra.models.Article;
import com.fil.sra.models.Category;
import com.fil.sra.models.Perishable;
import com.fil.sra.ports.IArticleRepository;
import com.fil.sra.ports.ICategoryRepository;
import com.fil.sra.ports.IStockRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LoadDBConfig {

    @Bean
    public CommandLineRunner load(
            ICategoryRepository categoryRepository,
            IArticleRepository articleRepository,
            IStockRepository stockRepository
    ) {

        return args -> {

            log.info("Loading sample data...");

            // Catégories
            Category fruits = Category.builder().id(1).name("Fruits").build();
            Category boissons = Category.builder().id(2).name("Boissons").build();
            Category patisserie = Category.builder().id(3).name("Pâtisserie").build();
            Category viande = Category.builder().id(4).name("Viande").build();

            categoryRepository.addCategory(fruits);
            categoryRepository.addCategory(boissons);
            categoryRepository.addCategory(patisserie);
            categoryRepository.addCategory(viande);

            // Articles normaux
            Article baguette = Article.builder()
                    .name("Pain")
                    .ean("1234567890123")
                    .price(1.20)
                    .categories(List.of(patisserie))
                    .build();

            Article jusOrange = Article.builder()
                    .name("Jus d'Orange")
                    .ean("2345678901234")
                    .price(3.50)
                    .categories(List.of(boissons, fruits))
                    .build();

            Article steak = Article.builder()
                    .name("Steak")
                    .ean("3456789012345")
                    .price(4.99)
                    .categories(List.of(viande))
                    .build();

            // Articles périssables
            Perishable yaourt = Perishable.builder()
                    .name("Yaourt")
                    .ean("4567890123456")
                    .price(2.50)
                    .categories(List.of(patisserie))
                    .bestBefore(new Date()) // Date du jour pour l'exemple
                    .build();

            Perishable poulet = Perishable.builder()
                    .name("Poulet")
                    .ean("5678901234567")
                    .price(7.99)
                    .categories(List.of(viande))
                    .bestBefore(new Date()) // Date du jour pour l'exemple
                    .build();

            // Ajout des articles et des périssables dans le dépôt avec les quantités de stock
            articleRepository.addArticle(baguette, 100);
            articleRepository.addArticle(jusOrange, 50);
            articleRepository.addArticle(steak, 30);
            articleRepository.addArticle(yaourt, 20);
            articleRepository.addArticle(poulet, 15);

            log.info("Sample data loaded successfully.");
        };

    }

}

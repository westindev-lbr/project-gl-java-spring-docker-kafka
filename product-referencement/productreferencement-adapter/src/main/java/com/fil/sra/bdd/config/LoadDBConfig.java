package com.fil.sra.bdd.config;

import com.fil.sra.models.Article;
import com.fil.sra.models.Category;
import com.fil.sra.models.Perishable;
import com.fil.sra.models.Stock;
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

            log.info("Hello world!");

            Category c1 = Category.builder().id(1).name("cat1").build();
            Category c2 = Category.builder().id(2).name("cat2").build();

            categoryRepository.addCategory(c1);
            categoryRepository.addCategory(c2);

            Article p1 = Article.builder()
                    .name("Product1")
                    .ean("ean1")
                    .price(5890.0)
                    .categories(List.of(c1, c2))
                    .build();

            Stock s1 = Stock.builder()
                    .article(p1)
                    .quantity(10)
                    .build();

            

            Perishable p2 =  Perishable.builder()
                    .name("ProductPerish")
                    .ean("ean2")
                    .price(5890.0)
                    .categories(List.of(c1, c2))
                    .bestBefore(new Date())
                    .build();

            articleRepository.createArticle(p2);
            articleRepository.createArticle(p2);

            log.info("GetArticlesByCriteria :");

            articleRepository.getArticlesByCriteria(null, "Prod", List.of("cat1", "cat2"), 5, 0)
                    .forEach(e -> log.info(e.getName()));
        };

    }

}

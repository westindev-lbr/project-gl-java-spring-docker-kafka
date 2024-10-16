package com.fil.sra.bdd.config;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.bdd.entity.PerishableEntity;
import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.bdd.repository.ArticleJPARepository;
import com.fil.sra.bdd.repository.CategoryJPARepository;
import com.fil.sra.bdd.repository.PerishableJPARepository;
import com.fil.sra.bdd.repository.ProductJPARepository;
import com.fil.sra.bdd.service.ArticleRepositoryImpl;
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
public class LoadDB {

    private final ArticleRepositoryImpl articleRepository;

    @Bean
    public CommandLineRunner load(CategoryJPARepository categoryJPARepository, ProductJPARepository productJPARepository, PerishableJPARepository perishableJPARepository, ArticleJPARepository articleJPARepository){

        return args -> {

            log.info("Hello world!");

            CategoryEntity test = new CategoryEntity();
            test.setName("cat1");
            categoryJPARepository.save(test);

            List<CategoryEntity> catEntity = List.of(test);

            ProductEntity p1 = new ProductEntity();
            p1.setName("Product1");
            p1.setEan("ean1");
            p1.setCategories(catEntity);
            p1.setPrice(5890.0);

            PerishableEntity p2 = new PerishableEntity();
            p2.setName("ProductPerish");
            p2.setEan("ean2");
            p2.setPrice(5890.0);
            p2.setBestBefore(new Date());


            productJPARepository.save(p1);
            perishableJPARepository.save(p2);

            log.info("\nProducts field");
            productJPARepository.findAll().forEach(e -> {
                ProductEntity product = (ProductEntity) e;
                log.info(product.getName());
            });

            log.info("\nPerishables field");
            perishableJPARepository.findAll().forEach(e -> {
                PerishableEntity perishable = (PerishableEntity) e;
                log.info(perishable.getName());
            });

            log.info("\nArticles field");
            articleJPARepository.findAll().forEach(e -> {
                ArticleEntity article = (ArticleEntity) e;
                log.info(article.getName());
            });

            articleRepository.getArticlesByCriteria("Prod",List.of("cat1"),1,5)
                    .forEach(e -> log.info(e.getName()));


            log.info("Salut jE");
        };

            }

}

package com.fil.sra.bdd.config;

import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.bdd.entity.PerishableEntity;
import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.bdd.repository.ArticleJPARepository;
import com.fil.sra.bdd.repository.CategoryJPARepository;
import com.fil.sra.bdd.repository.PerishableJPARepository;
import com.fil.sra.bdd.repository.ProductJPARepository;
import com.fil.sra.bdd.service.ArticleRepositoryImpl;
import com.fil.sra.interfaces.IArticleRepository;
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
    public CommandLineRunner load(CategoryJPARepository categoryJPARepository, ProductJPARepository productJPARepository, PerishableJPARepository perishableJPARepository,IArticleRepository articleRepository){

        return args -> {

            log.info("Hello world!");

            CategoryEntity test = new CategoryEntity();
            test.setName("cat1");
            categoryJPARepository.save(test);

            CategoryEntity test2 = new CategoryEntity();
            test2.setName("cat2");
            categoryJPARepository.save(test2);

            List<CategoryEntity> catEntity = List.of(test,test2);

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



            log.info("GetArticlesByCriteria :");
            articleRepository.getArticlesByCriteria(null,"Prod",List.of("cat1","cat2"),5,0)
                    .forEach(e -> log.info(e.getName()));
            };

    }

}

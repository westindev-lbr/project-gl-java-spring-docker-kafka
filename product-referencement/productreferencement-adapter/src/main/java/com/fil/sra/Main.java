package com.fil.sra;
import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.bdd.entity.PerishableEntity;
import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.bdd.repository.ArticleJPARepository;
import com.fil.sra.bdd.repository.CategoryJPARepository;
import com.fil.sra.bdd.repository.PerishableJPARepository;
import com.fil.sra.bdd.repository.ProductJPARepository;
import com.fil.sra.bdd.service.ArticleRepositoryImpl;
import com.fil.sra.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private ProductJPARepository productJPARepository;
    @Autowired
    private PerishableJPARepository perishableJPARepository;
    @Autowired
    private ArticleJPARepository articleJPARepository;
    @Autowired
    private CategoryJPARepository categoryJPARepository;
    @Autowired
    private ArticleRepositoryImpl articleRepository;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world!");

        CategoryEntity test = CategoryEntity.builder().name("cat1").build();
        categoryJPARepository.save(test);

        List<CategoryEntity> catEntity = List.of(test);

        ProductEntity p1 = ProductEntity.builder()
                .name("Product1")
                .ean("ean1")
                .categories(catEntity)
                .price(5890.0)
                .build();

        PerishableEntity p2 = PerishableEntity.builder()
                .name("ProductPerish")
                .ean("ean2")
                .price(5890.0)
                .bestBefore(new Date())
                .build();

        productJPARepository.save(p1);
        perishableJPARepository.save(p2);

        System.out.println("\nProducts field");
        productJPARepository.findAll().forEach(e -> {
            ProductEntity product = (ProductEntity) e;
            System.out.println(product.getName());
        });

        System.out.println("\nPerishables field");
        perishableJPARepository.findAll().forEach(e -> {
            PerishableEntity perishable = (PerishableEntity) e;
            System.out.println(perishable.getName());
        });

        System.out.println("\nArticles field");
        articleJPARepository.findAll().forEach(e -> {
            ArticleEntity article = (ArticleEntity) e;
            System.out.println(article.getName());
        });

        articleRepository.getArticlesByCriteria("Prod",List.of("cat1"),1,5)
                .forEach(e -> System.out.println(e.getName()));

    }
}

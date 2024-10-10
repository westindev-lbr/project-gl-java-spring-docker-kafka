package com.fil.sra;
import com.fil.sra.bdd.entity.PerishableEntity;
import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.bdd.repository.PerishableJPARepository;
import com.fil.sra.bdd.repository.ProductJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private ProductJPARepository productJPARepository;
    @Autowired
    private PerishableJPARepository perishableJPARepository;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world!");

        ProductEntity p1 = ProductEntity.builder()
                .name("Product1")
                .ean("ean1")
                .price(5890)
                .build();

        PerishableEntity p2 = PerishableEntity.builder()
                .name("ProductPerish")
                .ean("ean2")
                .price(5890)
                .bestBefore(new Date())
                .build();

        productJPARepository.save(p1);
        perishableJPARepository.save(p2);

        productJPARepository.findAll().forEach(e -> {
            ProductEntity product = (ProductEntity) e;
            System.out.println(product.getName());
        });

        perishableJPARepository.findAll().forEach(e -> {
            PerishableEntity perishable = (PerishableEntity) e;
            System.out.println(perishable.getName());
        });
    }
}

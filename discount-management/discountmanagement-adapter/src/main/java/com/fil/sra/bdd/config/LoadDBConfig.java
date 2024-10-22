package com.fil.sra.bdd.config;

import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.bdd.repository.ProductJPARepository;
import com.fil.sra.service.dto.ProductDto;
import com.fil.sra.service.proxy.ProductProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class LoadDBConfig {

    @Bean
    public CommandLineRunner load(ProductJPARepository productJPARepository,
                                  ProductProxy proxy) {

        return args -> {
            log.info("Hello world!");

            ProductEntity p1 = new ProductEntity();
            p1.setEan("P1");
            p1.setOriginalPrice(50);

            productJPARepository.save(p1);

            //productJPARepository.findAll().forEach(e -> log.info(e.getName()));

            List<ProductDto> res = proxy.getProductsByPage(null,"Prod",null,10,0);

            res.forEach(e -> log.info(e.getName()));

        };

    }

}

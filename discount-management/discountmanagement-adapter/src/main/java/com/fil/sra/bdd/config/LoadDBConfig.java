package com.fil.sra.bdd.config;

import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.service.dto.ProductDto;
import com.fil.sra.service.proxy.ProductProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
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
    public CommandLineRunner loadDB() {
        return args -> {
            log.info("Loading data in database");
            
        };
    }

}

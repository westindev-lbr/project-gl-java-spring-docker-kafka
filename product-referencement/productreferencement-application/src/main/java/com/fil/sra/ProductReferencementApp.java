package com.fil.sra;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.fil.sra.bdd", "com.fil.sra"})
@SpringBootApplication
public class ProductReferencementApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ProductReferencementApp.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
    }
}
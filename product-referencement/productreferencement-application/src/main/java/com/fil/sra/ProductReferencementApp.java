package com.fil.sra;


import com.fil.sra.annotation.Usecase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(includeFilters = @ComponentScan.Filter(classes = Usecase.class))
public class ProductReferencementApp{
    public static void main(String[] args) {
        SpringApplication.run(ProductReferencementApp.class, args);
    }
}
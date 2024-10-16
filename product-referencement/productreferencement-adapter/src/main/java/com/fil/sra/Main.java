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
public class Main  {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}

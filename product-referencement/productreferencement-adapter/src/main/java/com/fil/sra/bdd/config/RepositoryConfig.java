package com.fil.sra.bdd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fil.sra.bdd.mapper.ArticleEntityMapper;
import com.fil.sra.bdd.mapper.CategoryEntityMapper;
import com.fil.sra.bdd.mapper.StockEntityMapper;
import com.fil.sra.bdd.repository.ArticleJPARepository;
import com.fil.sra.bdd.repository.ArticleRepositoryImpl;
import com.fil.sra.bdd.repository.CategoryJPARepository;
import com.fil.sra.bdd.repository.CategoryRepositoryImpl;
import com.fil.sra.bdd.repository.StockJPARepository;
import com.fil.sra.bdd.repository.StockRepositoryImpl;
import com.fil.sra.ports.IArticleRepository;
import com.fil.sra.ports.ICategoryRepository;
import com.fil.sra.ports.IStockRepository;


@Configuration
public class RepositoryConfig {

    @Bean
    public IStockRepository stockRepository(StockJPARepository stockJPARepository,
            StockEntityMapper stockEntityMapper) {
        return new StockRepositoryImpl(stockJPARepository, stockEntityMapper);
    }

    @Bean
    public ICategoryRepository categoryRepository(CategoryJPARepository categoryJPARepository,
            CategoryEntityMapper categoryEntityMapper) {
        return new CategoryRepositoryImpl(categoryJPARepository, categoryEntityMapper);
    }

    @Bean
    public IArticleRepository articleRepository(
            ArticleJPARepository articleJPARepository,
            ArticleEntityMapper articleEntityMapper,
            CategoryJPARepository categoryJPARepository,
            CategoryEntityMapper categoryEntityMapper,
            StockJPARepository stockJPARepository,
            StockEntityMapper stockEntityMapper) {

        return new ArticleRepositoryImpl(
                articleJPARepository,
                articleEntityMapper,
                categoryJPARepository,
                categoryEntityMapper,
                stockJPARepository,
                stockEntityMapper);
    }
}

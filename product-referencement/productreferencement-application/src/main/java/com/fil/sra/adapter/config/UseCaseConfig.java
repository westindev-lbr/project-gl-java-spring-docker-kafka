package com.fil.sra.adapter.config;

import com.fil.sra.mapper.StockDtoMapper;
import com.fil.sra.ports.IArticleRepository;
import com.fil.sra.ports.IArticleUseCases;
import com.fil.sra.ports.ICategoryRepository;
import com.fil.sra.ports.IPerishableRepository;
import com.fil.sra.ports.IPerishableUseCase;
import com.fil.sra.ports.IStockRepository;
import com.fil.sra.ports.IStockUseCase;
import com.fil.sra.services.ArticleUseCasesImpl;
import com.fil.sra.services.PerishableUseCaseImpl;
import com.fil.sra.services.StockUseCaseImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public IArticleUseCases articleUseCases(
            IArticleRepository articleRepository,
            IStockRepository stockRepository,
            ICategoryRepository categoryRepository) {
        return new ArticleUseCasesImpl(articleRepository, stockRepository, categoryRepository);
    }

    @Bean
    public IStockUseCase stockUseCase(
            IStockRepository stockRepository,
            IArticleRepository articleRepository) {
        return new StockUseCaseImpl(stockRepository, articleRepository);
    }

    @Bean
    public IPerishableUseCase perishableUseCase(
            IPerishableRepository perishableRepository) {
        return new PerishableUseCaseImpl(perishableRepository);
    }
}

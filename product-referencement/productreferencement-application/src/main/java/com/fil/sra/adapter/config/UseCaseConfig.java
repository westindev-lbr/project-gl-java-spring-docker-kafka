package com.fil.sra.adapter.config;

import com.fil.sra.ports.IArticleRepository;
import com.fil.sra.ports.IArticleUseCases;
import com.fil.sra.ports.IStockRepository;
import com.fil.sra.ports.IStockUseCase;
import com.fil.sra.services.ArticleUseCasesImpl;
import com.fil.sra.services.StockUseCaseImpl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public IArticleUseCases articleUseCases(IArticleRepository articleRepository) {
        return new ArticleUseCasesImpl(articleRepository);
    }

    @Bean
    public IStockUseCase stockUseCase(IStockRepository stockRepository) {
        return new StockUseCaseImpl(stockRepository);
    }
}

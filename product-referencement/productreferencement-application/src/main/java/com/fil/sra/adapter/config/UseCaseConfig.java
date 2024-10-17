package com.fil.sra.adapter.config;

import com.fil.sra.interfaces.IArticleRepository;
import com.fil.sra.ports.IArticleUseCases;
import com.fil.sra.services.ArticleUseCasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public IArticleUseCases articleUseCases(IArticleRepository articleRepository){
        return new ArticleUseCasesImpl(articleRepository);
    }
}

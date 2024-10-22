package com.fil.sra.config;

import com.fil.sra.repository.MarketOperationRepository;
import com.fil.sra.usecase.MarketOperationUseCase;
import com.fil.sra.usecase.impl.MarketOperationUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarketOperationUseCaseConfig {

    @Bean
    public MarketOperationUseCase marketOperationUseCase(
            MarketOperationRepository marketOperationRepository
    ) {
        return new MarketOperationUseCaseImpl(marketOperationRepository);
    }
}

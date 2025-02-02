package com.fil.sra.config;

import com.fil.sra.mapper.MapperDTOToModelVV;
import com.fil.sra.ports.ICartServiceProxy;
import com.fil.sra.ports.ICartUseCase;
import com.fil.sra.ports.MarketOperationRepository;
import com.fil.sra.usecase.CartUseCaseImpl;
import com.fil.sra.usecase.MarketOperationUseCase;
import com.fil.sra.usecase.impl.MarketOperationUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarketOperationUseCaseConfig {

    @Bean
    public MarketOperationUseCase marketOperationUseCase(
            MarketOperationRepository marketOperationRepository,
            MapperDTOToModelVV mapperDTOToModelVV
    ) {
        return new MarketOperationUseCaseImpl(marketOperationRepository,mapperDTOToModelVV);
    }

    @Bean
    public ICartUseCase cartUseCase(
        ICartServiceProxy cartServiceProxy
    ) {
        return new CartUseCaseImpl(cartServiceProxy);
    }
}

package com.fil.sra.usecase.impl;

import com.fil.sra.dto.MarketOperationDTO;
import com.fil.sra.mapper.MapperDTOToModelVV;
import com.fil.sra.model.MarketOperation;
import com.fil.sra.repository.MarketOperationRepository;
import com.fil.sra.usecase.MarketOperationUseCase;

public class MarketOperationUseCaseImpl implements MarketOperationUseCase {

    public MarketOperationRepository marketOperationRepository;

    private MapperDTOToModelVV mapperDTOToModelVV;

    public MarketOperationDTO addMarketOperation() {
        MarketOperation marketOperation = marketOperationRepository.addOperation();
        // SEND KAFKA IF VALIDE SINON RETURN null
        return marketOperation;
    }
}

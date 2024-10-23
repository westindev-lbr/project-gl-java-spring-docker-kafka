package com.fil.sra.usecase;

import com.fil.sra.dto.MarketOperationDTO;

import java.util.List;

public interface MarketOperationUseCase {

    public MarketOperationDTO addMarketOperation(MarketOperationDTO marketOperationDTO, List<String> eans);
}

package com.fil.sra.usecase;

import com.fil.sra.command.AddMarketOperationCommand;
import com.fil.sra.dto.MarketOperationDTO;
import com.fil.sra.dto.TypeOfMarketOperationDTO;

import java.util.List;

public interface MarketOperationUseCase {

    public MarketOperationDTO addMarketOperation(AddMarketOperationCommand addMarketOperationCommand, TypeOfMarketOperationDTO typeOfMarketOperationDTO);

    public List<MarketOperationDTO> getAllMarketOperations();

    public MarketOperationDTO getMarketOperationById(int id);

    public void deleteMarketOperationById(int id);
}

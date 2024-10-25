package com.fil.sra.ports;

import com.fil.sra.exception.ProductDoesNotExistException;
import com.fil.sra.model.MarketOperation;

import java.util.List;


public interface MarketOperationRepository {

    MarketOperation addOperation(MarketOperation marketOperation) throws ProductDoesNotExistException;

    List<MarketOperation>  getAllMarketOperations();

    MarketOperation getMarketOperationById(int id);

    void deleteMarketOperationById(int id);
}

package com.fil.sra.services;

import com.fil.sra.ports.IStockRepository;
import com.fil.sra.ports.IStockUseCase;


public class StockUseCaseImpl implements IStockUseCase  {

    private final IStockRepository stockRepository;

    public StockUseCaseImpl(IStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void updateStock(int id, int quantity) {
        stockRepository.updateStock(id, quantity);
    }
} 

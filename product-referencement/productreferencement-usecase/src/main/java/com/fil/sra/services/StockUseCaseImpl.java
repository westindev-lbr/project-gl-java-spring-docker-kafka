package com.fil.sra.services;

import com.fil.sra.exception.NotEnoughStockQuantityException;
import com.fil.sra.models.Stock;
import com.fil.sra.ports.IStockRepository;
import com.fil.sra.ports.IStockUseCase;


public class StockUseCaseImpl implements IStockUseCase  {

    private final IStockRepository stockRepository;

    public StockUseCaseImpl(IStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Void updateStock(int id, int quantity) {
        Stock stock = stockRepository.updateStock(id, quantity);
        if (stock == null) {
            throw new NotEnoughStockQuantityException("Stock not found");
        }
        return null;
    }
} 

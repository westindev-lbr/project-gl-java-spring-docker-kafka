package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.StockEntity;
import com.fil.sra.bdd.mapper.StockEntityMapper;
import com.fil.sra.models.Stock;
import com.fil.sra.ports.IStockRepository;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class StockRepositoryImpl implements IStockRepository {
    
    private final StockJPARepository stockJPARepository;
    private final StockEntityMapper stockEntityMapper;

    public StockRepositoryImpl(StockJPARepository stockJPARepository, StockEntityMapper stockEntityMapper) {
        this.stockJPARepository = stockJPARepository;
        this.stockEntityMapper = stockEntityMapper;
    }

    public Stock updateStock(int id, int quantity) {
        Optional<StockEntity> stockEntity = stockJPARepository.findByArticleId(id);
        if (!stockEntity.isPresent()) return null;
        stockEntity.get().setQuantity(quantity);
        StockEntity savedEntity =  stockJPARepository.save(stockEntity.get());
        return stockEntityMapper.toStock(savedEntity);
    }

    public Stock getStock(int id) {
        Optional<StockEntity> stockEntity = stockJPARepository.findById(id);
        if (!stockEntity.isPresent()) return null;
        return stockEntityMapper.toStock(stockEntity.get());
    }

    public Stock addStock(Stock stock) {
        StockEntity stockEntity = stockEntityMapper.toStockEntity(stock);
        StockEntity savedStockEntity = stockJPARepository.save(stockEntity);
        return stockEntityMapper.toStock(savedStockEntity);
    }
}

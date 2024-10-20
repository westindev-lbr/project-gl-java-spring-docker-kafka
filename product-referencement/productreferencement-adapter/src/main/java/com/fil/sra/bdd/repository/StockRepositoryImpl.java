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

    public Optional<Void> updateStock(int id, int quantity) {
        StockEntity stockEntity = stockJPARepository.findByArticleId(id);
        stockEntity.setQuantity(quantity);
        stockJPARepository.save(stockEntity);
        return Optional.empty();
    }

    public Optional<Stock> getStock(int id) {
        StockEntity stockEntity = stockJPARepository.findById(id);
        Stock stock = Stock.builder()
                .id(stockEntity.getId())
                .quantity(stockEntity.getQuantity())
                .build();
        return Optional.of(stock);
    }

    @Override
    public Optional<Void> addStock(Stock stock) {
        StockEntity stockEntity = stockEntityMapper.toStockEntity(stock);
        stockJPARepository.save(stockEntity);
        return Optional.empty();
    }

}

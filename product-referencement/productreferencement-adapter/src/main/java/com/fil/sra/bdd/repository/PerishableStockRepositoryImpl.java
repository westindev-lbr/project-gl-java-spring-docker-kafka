package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.PerishableStockEntity;
import com.fil.sra.bdd.mapper.PerishableStockEntityMapper;
import com.fil.sra.models.PerishableStock;
import com.fil.sra.ports.IPerishableStockRepository;
import org.springframework.stereotype.Component;

@Component
public class PerishableStockRepositoryImpl implements IPerishableStockRepository {

    private final PerishableStockJPARepository perishableStockJPARepository;
    private final PerishableStockEntityMapper perishableStockEntityMapper;

    public PerishableStockRepositoryImpl(PerishableStockJPARepository perishableStockJPARepository, PerishableStockEntityMapper perishableStockEntityMapper){
        this.perishableStockJPARepository = perishableStockJPARepository;
        this.perishableStockEntityMapper = perishableStockEntityMapper;
    }

    @Override
    public PerishableStock getPerishableStockByArticleId(int articleId) {
        return this.perishableStockJPARepository.findByPerishableId(articleId).map(perishableStockEntityMapper::toPerishableStock).orElse(null);
    }

    @Override
    public PerishableStock updatePerishableStock(int id, int quantity) {

        return null;
    }

    @Override
    public PerishableStock addStock(PerishableStock stock) {
        return null;
    }
}

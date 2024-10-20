package com.fil.sra.ports;

import java.util.Optional;

import com.fil.sra.models.Stock;

public interface IStockRepository {
    Optional<Void> updateStock(int id, int quantity);
    Optional<Void> addStock(Stock stock);
}

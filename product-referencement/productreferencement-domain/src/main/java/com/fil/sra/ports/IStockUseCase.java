package com.fil.sra.ports;

public interface IStockUseCase {
    Void updateStock(int articleId, int quantity);
}

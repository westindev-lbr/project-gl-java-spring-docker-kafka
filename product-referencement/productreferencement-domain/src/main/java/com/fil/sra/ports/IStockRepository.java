package com.fil.sra.ports;

import com.fil.sra.models.Stock;

public interface IStockRepository {
    Stock getStockByArticleId(int articleId);
    Stock updateStock(int id, int quantity);

    Stock getStock(int id);

    Stock addStock(Stock stock);
}

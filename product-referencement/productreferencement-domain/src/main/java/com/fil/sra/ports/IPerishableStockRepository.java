package com.fil.sra.ports;


import com.fil.sra.models.PerishableStock;

public interface IPerishableStockRepository {
    PerishableStock getPerishableStockByArticleId(int articleId);
    PerishableStock updatePerishableStock(int id, int quantity);
    PerishableStock addStock(PerishableStock stock);
}

package com.fil.sra.ports;

import com.fil.sra.dto.StockDto;

public interface IStockUseCase {
    StockDto updateStock(int articleId, int quantity);
}

package com.fil.sra;

import com.fil.sra.models.ProductStock;
import com.fil.sra.models.Stock;

public class ProductStockTest extends StockTest{
    public Stock createStock(){
        return new ProductStock();
    }
}

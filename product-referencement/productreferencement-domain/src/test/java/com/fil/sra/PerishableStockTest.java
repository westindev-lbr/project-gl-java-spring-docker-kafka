package com.fil.sra;


import com.fil.sra.models.PerishableStock;
import com.fil.sra.models.Stock;

public class PerishableStockTest extends StockTest{
    public Stock createStock(){
        return new PerishableStock();
    }
}

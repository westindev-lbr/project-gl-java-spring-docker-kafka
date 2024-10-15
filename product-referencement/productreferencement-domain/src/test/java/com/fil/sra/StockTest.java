package com.fil.sra;

import com.fil.sra.exception.NotEnoughStockQuantityException;
import com.fil.sra.models.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StockTest {

    protected Stock stock;
    @BeforeEach
    public void setUp(){
        this.stock = this.createStock();
    }
    public Stock createStock(){
        return new Stock();
    }

    @Test
    public void testIncreaseQuantity(){
        assertEquals(0,this.stock.getQuantity());
        this.stock.increaseQuantity(10);
        assertEquals(10,this.stock.getQuantity());
    }

    @Test
    public void testDecreaseQuantityWhenStockIsEnought(){
        this.stock.increaseQuantity(10);
        assertEquals(10,this.stock.getQuantity());
        this.stock.decreaseQuantity(10);
        assertEquals(0,this.stock.getQuantity());
    }

    @Test
    public void testDecreaseQuantityWhenStockIsNotEnought(){
        assertEquals(0,this.stock.getQuantity());
        assertThrows(NotEnoughStockQuantityException.class,() -> {
            this.stock.decreaseQuantity(10);
        });
        assertEquals(0,this.stock.getQuantity());
    }


}

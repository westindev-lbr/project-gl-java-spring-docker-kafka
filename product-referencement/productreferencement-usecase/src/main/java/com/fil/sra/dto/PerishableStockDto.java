package com.fil.sra.dto;

import com.fil.sra.models.Perishable;
import com.fil.sra.models.Stock;

import java.util.Date;

public record PerishableStockDto(
        int quantity,
        Date bestBefore,
        String lot,
        Perishable perishable,
        Stock globalStock
) {}

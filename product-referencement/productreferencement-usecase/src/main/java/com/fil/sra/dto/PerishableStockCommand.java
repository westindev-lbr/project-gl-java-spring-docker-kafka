package com.fil.sra.dto;

import java.util.Date;

public record PerishableStockCommand(
         String ean,
         Date bestBefore,
         String lot,
         int quantity
)  {
}

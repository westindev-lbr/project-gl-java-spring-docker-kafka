package com.fil.sra.ports;

import com.fil.sra.dto.PerishableStockCommand;
import com.fil.sra.dto.PerishableStockDto;
import com.fil.sra.models.PerishableStock;

public interface IPerishableStockUseCase {

    PerishableStockDto addPerishableStock(PerishableStockCommand command);

}

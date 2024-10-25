package com.fil.sra.services;

import com.fil.sra.annotation.Usecase;
import com.fil.sra.dto.PerishableStockCommand;
import com.fil.sra.dto.PerishableStockDto;
import com.fil.sra.exception.ResourceNotFoundException;
import com.fil.sra.mapper.PerishableStockDtoMapper;
import com.fil.sra.models.Perishable;
import com.fil.sra.models.PerishableStock;
import com.fil.sra.models.Stock;
import com.fil.sra.ports.IPerishableRepository;
import com.fil.sra.ports.IPerishableStockRepository;
import com.fil.sra.ports.IPerishableStockUseCase;
import com.fil.sra.ports.IStockRepository;

@Usecase
public class PerishableStockUseCaseImpl implements IPerishableStockUseCase {

    private final IPerishableStockRepository perishableStockRepository;
    private final IStockRepository stockRepository;
    private final IPerishableRepository perishableRepository;

    public PerishableStockUseCaseImpl(IPerishableStockRepository perishableStockRepository,
                                      IStockRepository stockRepository,
                                      IPerishableRepository perishableRepository){
        this.perishableStockRepository = perishableStockRepository;
        this.stockRepository = stockRepository;
        this.perishableRepository = perishableRepository;
    }


    @Override
    public PerishableStockDto addPerishableStock(PerishableStockCommand command) {
        Perishable perishable = this.perishableRepository.getPerishableByEan(command.ean());
        PerishableStock perishableStock = PerishableStockDtoMapper.INSTANCE.toCommand(command);
        perishableStock.setPerishable(perishable);
        PerishableStock savedStock = this.perishableStockRepository.addPerishableStock(perishableStock);
        return PerishableStockDtoMapper.INSTANCE.toDto(savedStock);
    }

//    @Override
//    public PerishableStockDto updatePerishableStock(Integer articleId, PerishableStockDto dto) {
//        if(this.perishableStockRepository.getPerishableStockByArticleId(articleId) == null)
//            throw new ResourceNotFoundException("Perishable stock not found");
//        PerishableStock stock = this.perishableStockRepository.updatePerishableStock(PerishableStockDtoMapper.INSTANCE.toStock(dto));
//        return PerishableStockDtoMapper.INSTANCE.toDto(stock);
//    }
}

package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.MarketOperationEntity;
import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.bdd.mapper.MapperEntityToModelVV;
import com.fil.sra.exception.ProductDoesNotExistException;
import com.fil.sra.model.MarketOperation;
import com.fil.sra.repository.MarketOperationRepository;
import com.fil.sra.service.dto.ProductDto;
import com.fil.sra.service.proxy.ProductProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class MarketOperationRepositoryImpl implements MarketOperationRepository {

    private final MarketOperationJPARepository marketOperationJPARepository;

    protected MapperEntityToModelVV mapperEntityToModelVV;

    protected ProductProxy productProxy;

    public MarketOperationRepositoryImpl(MarketOperationJPARepository marketOperationJPARepository){
        this.marketOperationJPARepository = marketOperationJPARepository;
    }

    public MarketOperation addOperation(MarketOperation marketOperation) throws ProductDoesNotExistException {
        MarketOperationEntity entity = mapperEntityToModelVV.toMarketOperationEntity(marketOperation);
        for(ProductEntity productEntity : entity.getProducts()) {
            List<ProductDto> temp = productProxy.getProductsByPage(productEntity.getEan(), null,null,10,1);
            if(temp.size() == 1){
                productEntity.setActualPrice(temp.get(0).getPrice());
                productEntity.setOriginalPrice(temp.get(0).getPrice());
            }
            else{
                throw new ProductDoesNotExistException("The Ean: " + temp.get(0) + " given doesn't exist in Product DB");
            }
        }
        MarketOperationEntity entitySaved = marketOperationJPARepository.save(entity);
        return marketOperation;
    }

}

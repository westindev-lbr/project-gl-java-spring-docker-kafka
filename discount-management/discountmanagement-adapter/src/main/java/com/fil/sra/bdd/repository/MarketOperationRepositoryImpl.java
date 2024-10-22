package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.MarketOperationEntity;
import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.bdd.mapper.MapperEntityToModelVV;
import com.fil.sra.exception.ProductDoesNotExistException;
import com.fil.sra.model.MarketOperation;
import com.fil.sra.repository.MarketOperationRepository;
import com.fil.sra.service.dto.ProductDto;
import com.fil.sra.service.proxy.ProductProxy;

import java.util.List;

public class MarketOperationRepositoryImpl implements MarketOperationRepository {

    protected MarketOperationJPARepository marketOperationJPARepository;

    protected MapperEntityToModelVV mapperEntityToModelVV;

    protected ProductProxy productProxy;

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

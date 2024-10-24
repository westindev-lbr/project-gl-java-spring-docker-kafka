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

import java.util.ArrayList;
import java.util.List;

@Component
public class MarketOperationRepositoryImpl implements MarketOperationRepository {

    private final MarketOperationJPARepository marketOperationJPARepository;

    private final MapperEntityToModelVV mapperEntityToModelVV;

    private final ProductProxy productProxy;

    public MarketOperationRepositoryImpl(MarketOperationJPARepository marketOperationJPARepository,MapperEntityToModelVV mapperEntityToModelVV, ProductProxy productProxy){
        this.marketOperationJPARepository = marketOperationJPARepository;
        this.productProxy = productProxy;
        this.mapperEntityToModelVV = mapperEntityToModelVV;
    }

    public MarketOperation addOperation(MarketOperation marketOperation) throws ProductDoesNotExistException {
        MarketOperationEntity entity = mapperEntityToModelVV.toMarketOperationEntity(marketOperation);
        for(ProductEntity productEntity : entity.getProducts()) {
            List<ProductDto> temp = productProxy.getProductsByPage(productEntity.getEan(), null,null,10,0);
            if(temp.size() == 1){
                productEntity.setActualPrice(temp.get(0).getPrice());
                productEntity.setOriginalPrice(temp.get(0).getPrice());
            }
            else{
                throw new ProductDoesNotExistException("The Ean: " + temp.get(0) + " given doesn't exist in Product DB");
            }
        }
        marketOperationJPARepository.save(entity);
        return mapperEntityToModelVV.toMarketOperation(entity);
    }

    public List<MarketOperation> getAllMarketOperations() {
        List<MarketOperation> marketOperations = new ArrayList<>();
        this.marketOperationJPARepository.findAll().forEach(marketOperationEntity -> marketOperations.add(mapperEntityToModelVV.toMarketOperation(marketOperationEntity)));
        return marketOperations;
    }

    public MarketOperation getMarketOperationById(int id) {
        MarketOperationEntity entity = this.marketOperationJPARepository.findById(id).orElse(null);
        return this.mapperEntityToModelVV.toMarketOperation(entity);
    }

    public void deleteMarketOperationById(int id) {
        this.marketOperationJPARepository.deleteById(id);
    }

}

package com.fil.sra.bdd.service;

import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.bdd.mapper.ProductEntityMapper;
import com.fil.sra.bdd.repository.ProductJPARepository;
import com.fil.sra.models.Product;
import com.fil.sra.port.IArticleRepository;
import com.fil.sra.port.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductRepositoryImpl implements IProductRepository {

    private final ProductJPARepository productJPARepository;
    private final IArticleRepository articleRepository;

    public ProductRepositoryImpl(IArticleRepository articleRepository,ProductJPARepository productJPARepository){
        this.articleRepository = articleRepository;
        this.productJPARepository = productJPARepository;
    }

    @Override
    public Product getProduct(Integer id) {
        return this.productJPARepository.findById(id).map(ProductEntityMapper.INSTANCE::toProduct).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity entity = this.productJPARepository.save(ProductEntityMapper.INSTANCE.toProductEntity(product));
        return ProductEntityMapper.INSTANCE.toProduct(entity);
    }

    @Override
    public Product updateProduct(Product product) {
        articleRepository.updateArticle(product); // On va persiter les updates liées à article
        Optional<ProductEntity> entity = productJPARepository.findById(product.getId());
        // Product n'a pour le moment pas d'attribut en plus
        return entity.map(ProductEntityMapper.INSTANCE::toProduct).orElse(null);
    }

    @Override
    public void deleteProduct(Integer id) {
        productJPARepository.deleteById(id);
    }
}

package com.fil.sra.port;

import com.fil.sra.models.Product;

public interface IProductRepository {
    Product getProduct(Integer id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Integer id);
}

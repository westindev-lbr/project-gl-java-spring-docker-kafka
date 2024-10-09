package com.fil.sra.bdd.repository;



import com.fil.sra.bdd.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductJPARepository extends CrudRepository<ProductEntity,Integer> {
}

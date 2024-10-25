package com.fil.sra.bdd.repository;
import com.fil.sra.bdd.entity.PerishableEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerishableJPARepository extends CrudRepository<PerishableEntity,Integer> {
//    Optional<PerishableEntity> findByEan(String ean);
    @Query("SELECT p FROM perishable p WHERE p.ean = :ean")
    Optional<PerishableEntity> findByEan(@Param("ean") String ean);
}

package com.fil.sra.bdd.repository;
import com.fil.sra.bdd.entity.PerishableEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerishableJPARepository extends CrudRepository<PerishableEntity,Integer> {
    List<PerishableEntity> findByBestBeforeBefore(Date currentDate);
//    Optional<PerishableEntity> findByEan(String ean);
    @Query("SELECT p FROM perishable p WHERE p.ean = :ean")
    Optional<PerishableEntity> findByEan(@Param("ean") String ean);
}

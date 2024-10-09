package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.PerishableEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PerishableJPARepository extends CrudRepository<PerishableEntity,Integer> {
}

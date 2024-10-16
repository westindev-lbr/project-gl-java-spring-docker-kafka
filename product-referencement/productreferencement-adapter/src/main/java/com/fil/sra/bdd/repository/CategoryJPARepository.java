package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryJPARepository extends CrudRepository<CategoryEntity, Integer> {
    CategoryEntity findByName(String name);  // Renvoie directement une catégorie
}

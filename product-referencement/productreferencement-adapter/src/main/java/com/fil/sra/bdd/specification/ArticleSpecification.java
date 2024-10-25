package com.fil.sra.bdd.specification;

import com.fil.sra.bdd.entity.CategoryEntity;
import org.springframework.data.jpa.domain.Specification;
import com.fil.sra.bdd.entity.ArticleEntity;

import java.util.List;

public class ArticleSpecification {

    public static Specification<ArticleEntity> hasEan(String ean) {
        return (root, query, criteriaBuilder) ->
                ean == null ? null : criteriaBuilder.equal(root.get("ean"), ean);
    }

    public static Specification<ArticleEntity> hasNameContaining(String subName) {
        return (root, query, criteriaBuilder) ->
                subName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + subName.toLowerCase() + "%");
    }

    public static Specification<ArticleEntity> hasCategories(List<CategoryEntity> categories) {
        return (root, query, criteriaBuilder) -> {
            if (categories == null || categories.isEmpty()) {
                return null;
            } else {
                return root.join("categories").in(categories);
            }
        };
    }

}


package com.fil.sra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fil.sra.models.Article;
import com.fil.sra.models.Category;

public class ArticleTest {

    @Test
    public void createArticle() {

        Article article = new Article();        
        article.setId(1);
        article.setBrand("Cristaline");
        article.setPrice(1.0);
        article.setName("Bouteille d'eau 1L");
        article.setReference("123456789");
        article.setVat(0.2);
        article.setImg("https://franprix.twic.pics/product-images/3254381025887_H1N1_s06?twic=v1/output=jpeg/cover=420x-");
        article.addCategory(new Category("Boisson"));

        List<Category> expectedCategories = new ArrayList<Category>();
        expectedCategories.add(new Category("Boisson"));

        assertEquals(1, article.getId());
        assertEquals("Cristaline", article.getBrand());
        assertEquals(1.0, article.getPrice());
        assertEquals("Bouteille d'eau 1L", article.getName());
        assertEquals("123456789", article.getReference());
        assertEquals(0.2, article.getVat());
        assertEquals("https://franprix.twic.pics/product-images/3254381025887_H1N1_s06?twic=v1/output=jpeg/cover=420x-", article.getImg());
        assertEquals(1, article.getCategories().size());
        assertThat(expectedCategories).usingRecursiveComparison().isEqualTo(article.getCategories());
    }
}

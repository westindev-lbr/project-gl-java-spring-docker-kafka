package com.fil.sra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fil.sra.models.Article;
import com.fil.sra.models.Category;

class ArticleTest {

    @Test
    void createArticle() {

        Article article = Article.builder()
                .id(1)
                .brand("Cristaline")
                .price(1.0)
                .name("Bouteille d'eau 1L")
                .reference("123456789")
                .vat(0.2)
                .img(
                        "https://franprix.twic.pics/product-images/3254381025887_H1N1_s06?twic=v1/output=jpeg/cover=420x-")
                .build();

        List<Category> expectedCategories = new ArrayList<Category>();
        Category category = Category.builder()
                .id(1)
                .name("Boisson")
                .orderIdx(2)
                .build();
        expectedCategories.add(category);

        article.setCategories(expectedCategories);

        assertEquals(1, article.getId());
        assertEquals("Cristaline", article.getBrand());
        assertEquals(1.0, article.getPrice());
        assertEquals("Bouteille d'eau 1L", article.getName());
        assertEquals("123456789", article.getReference());
        assertEquals(0.2, article.getVat());
        assertEquals("https://franprix.twic.pics/product-images/3254381025887_H1N1_s06?twic=v1/output=jpeg/cover=420x-",
                article.getImg());
        assertEquals(1, article.getCategories().size());
        assertThat(expectedCategories).usingRecursiveComparison().isEqualTo(article.getCategories());
    }
}

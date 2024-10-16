package com.fil.sra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fil.sra.models.Category;

class CategoryTest {

    @Test
    void createCategory() {

        Category category = Category.builder()
                .id(1)
                .name("Boisson")
                .orderIdx(2)
                .build();

        assertEquals(1, category.getId());
        assertEquals("Boisson", category.getName());
        assertEquals(2, category.getOrderIdx());
    }

    @Test
    void updateCategory() {

        Category category = Category.builder()
                .id(2)
                .name("Alimentation")
                .orderIdx(1)
                .build();

        assertEquals(2, category.getId());
        assertEquals("Alimentation", category.getName());
        assertEquals(1, category.getOrderIdx());
    }

}

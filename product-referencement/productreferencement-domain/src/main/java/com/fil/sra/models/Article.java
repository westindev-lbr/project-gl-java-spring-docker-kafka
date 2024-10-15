package com.fil.sra.models;

import lombok.NoArgsConstructor;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Article {

    protected int id;
    protected String brand;
    protected double price;
    protected String name;
    protected String reference;
    protected double vat;
    protected String img;
    protected List<Category> categories;

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
    }
}

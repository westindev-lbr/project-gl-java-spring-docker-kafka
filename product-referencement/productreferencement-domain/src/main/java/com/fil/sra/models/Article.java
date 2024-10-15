package com.fil.sra.models;

import java.util.List;

public class Article {

    private int id;
    private String brand;
    private double price;
    private String name;
    private String reference;
    private double vat;
    private String img;
    private List<Category> categories;

    public Integer getId() { return this.id; }
    public void setId(int i) {this.id = i;}

    public String getReference() { return this.reference; }
    public void setReference(String code) {this.reference = code;}

    public String getName() { return this.name; }
    public void setName(String name) {this.name = name;}

    public double getPrice() { return this.price; } 
    public void setPrice(double price) {this.price = price;}
    
    public String getBrand() { return this.brand; }
    public void setBrand(String brand) {this.brand = brand;}

    public void addCategory(Category category) {this.categories.add(category);}

    public String getImg() { return this.img; }
    public void setImg(String img) {this.img = img;}

    public double getVat() { return this.vat; }
    public void setVat(double vat) {this.vat = vat;}

    public List<Category> getCategories() {return this.categories;}
    public void setCategories(List<Category> categories) {this.categories = categories;}
}

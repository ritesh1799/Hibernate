package com.hibernate.ManyToMany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Column(name = "Category_ID")
    @Id
    private int categoryId;

    @Column(name = "Category_Type")
    private String categoryType;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();


    public Category() {
    }

    public Category(int categoryId, String categoryType) {
        this.categoryId = categoryId;
        this.categoryType = categoryType;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public List<Product> getProductList() {
        return productList;
    }
}

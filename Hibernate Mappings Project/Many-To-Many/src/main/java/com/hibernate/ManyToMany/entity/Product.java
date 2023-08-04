package com.hibernate.ManyToMany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Column(name = "Product_ID")
    @Id
    private int productId;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Price")
    private int price;

    //we will create a bidirectional relationship and we use mapped by for that.
    //we don't need to give mapped by in both the entities as mapping one side is enough to create bidirectional relationship.
    @ManyToMany(mappedBy = "productList",fetch = FetchType.EAGER)
    private List<Category> categoryList = new ArrayList<>();

    //Now as we mapped the table using categoryList now it will create a new table in DB


    public Product() {
    }


    public Product(int productId, String productName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }


    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

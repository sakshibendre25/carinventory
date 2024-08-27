package com.sakshi.springboot.carinventory.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_Id", length = 11)
    private int productId;

    @Column(name = "product_Name", length = 45)
    private String productName;


    @ManyToOne
    @JoinColumn(name = "cat_Id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_Id", nullable = false)
    private Brand brand;

    @Column(name = "Price", length = 45)
    private double price;


    @Column(name = "active", columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "products")
    private Set<SalesDetails> salesDetails;


    public Product(int productId, String productName, Category category, Brand brand, double price, boolean active) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.active = active;
    }

    public Product(String productName, Category category, Brand brand, double price, boolean active) {
        this.productName = productName;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.active = active;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                ", brand=" + brand +
                ", price=" + price +
                ", active=" + active +
                '}';
    }
}
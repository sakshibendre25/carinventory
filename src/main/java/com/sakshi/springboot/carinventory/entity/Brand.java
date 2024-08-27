package com.sakshi.springboot.carinventory.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="brand_Id",length = 11)
    private int brandId;

    @Column(name="brand_Name",length = 45)
    private String brandName;

    @Column(name="active",columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products;

    public Brand(int brandId, String brandName, boolean active) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.active = active;
    }

    public Brand(String brandName, boolean active) {
        this.brandName = brandName;
        this.active = active;
    }


    public Brand() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", active=" + active +
                '}';
    }

}
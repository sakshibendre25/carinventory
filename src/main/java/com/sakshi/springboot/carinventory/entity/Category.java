package com.sakshi.springboot.carinventory.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "cat_id",length = 11)
    private int catid;

    @Column(name = "cat_name",length = 45)
     private String catname;

    @Column(name = "active",columnDefinition = "TINYINT default 1")
    private boolean active;


    @OneToMany(mappedBy = "category")
    private Set<Product> products;


    // crate constructor


    public Category(int catid, String catname, boolean active) {
        this.catid = catid;
        this.catname = catname;
        this.active = active;
    }

    public Category(String catname, boolean active) {
        this.catname = catname;
        this.active = active;
    }

    public Category() {
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catid=" + catid +
                ", catname='" + catname + '\'' +
                ", active=" + active +
                '}';
    }
}

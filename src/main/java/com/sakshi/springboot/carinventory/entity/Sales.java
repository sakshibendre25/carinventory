package com.sakshi.springboot.carinventory.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sales_Id", length = 11)
    private int salesId;

    @Column(name = "date", length = 45)
    private String date;

    @Column(name = "total", length = 45)
    private double total;

    @OneToMany(mappedBy = "sales")
    private Set<SalesDetails> salesDetails;

    public Sales(int salesId, String date, double total, Set<SalesDetails> salesDetails) {
        this.salesId = salesId;
        this.date = date;
        this.total = total;
        this.salesDetails = salesDetails;
    }

    public Sales(String date, double total) {
        this.date = date;
        this.total = total;
    }

    public Sales() {
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<SalesDetails> getSalesDetails() {
        return salesDetails;
    }

    public void setSalesDetails(Set<SalesDetails> salesDetails) {
        this.salesDetails = salesDetails;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesId=" + salesId +
                ", date='" + date + '\'' +
                ", total=" + total +
                ", salesDetails=" + salesDetails +
                '}';
    }
}
package com.sakshi.springboot.carinventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data


@Entity
@Table(name="sales")
public class SalesDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sales_details_Id", length = 11)
    private int salesdetailsId;

    @Column(name = "product_Name", length = 45)
    private int productName;

    @Column(name = "qty", length = 45)
    private double qty;

    @Column(name = "amount", length = 45)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "sales_Id", nullable = false)
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "product_Id", nullable = false)
    private Product products;

}




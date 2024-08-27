package com.sakshi.springboot.carinventory.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDetailsDTO {


    private int salesdetailsId;

    private int productName;

    private double qty;

    private double amount;



}

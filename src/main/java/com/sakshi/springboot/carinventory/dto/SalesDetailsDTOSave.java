package com.sakshi.springboot.carinventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDetailsDTOSave {

    private int salesdetailsid;
    private  String productname;
    private double qty;
    private double amount;
    private int salesid;
    private int productid;


}

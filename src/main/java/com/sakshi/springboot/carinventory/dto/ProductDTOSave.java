package com.sakshi.springboot.carinventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTOSave {


    private String productname;

    private int catid;

    private int brandid;

    private  double price;

    private boolean active;
}

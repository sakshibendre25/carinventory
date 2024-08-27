package com.sakshi.springboot.carinventory.dto;

import com.sakshi.springboot.carinventory.entity.Brand;
import com.sakshi.springboot.carinventory.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {


    private int productid;

    private String productname;

    private Category category;

    private Brand brand;

    private double price;

    private boolean active;

}

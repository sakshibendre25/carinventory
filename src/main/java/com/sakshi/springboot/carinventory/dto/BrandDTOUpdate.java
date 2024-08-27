package com.sakshi.springboot.carinventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BrandDTOUpdate {
    private int brandId;
    private String brandName;
    private boolean active;
}
package com.sakshi.springboot.carinventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDTOSave {

    private int salesid;
    private String date;
    private  double total;

    private List<SalesDetailsDTOSave>salesDTOSave;
}

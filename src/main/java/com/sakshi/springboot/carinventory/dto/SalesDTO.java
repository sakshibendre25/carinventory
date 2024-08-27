package com.sakshi.springboot.carinventory.dto;

import com.sakshi.springboot.carinventory.entity.SalesDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDTO {

    private int salesid;
    private Date date;
    private double total;

    private Set<SalesDetails>salesDetails;

}

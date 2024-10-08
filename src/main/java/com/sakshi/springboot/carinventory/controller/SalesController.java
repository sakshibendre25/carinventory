package com.sakshi.springboot.carinventory.controller;

import com.sakshi.springboot.carinventory.dto.SalesDTOSave;
import com.sakshi.springboot.carinventory.service.SalesService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RestController
@CrossOrigin
@RequestMapping("api/v1/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping("/save")
    public  String saveSales(@RequestBody SalesDTOSave salesDTOSave)
    {
        System.out.println(salesDTOSave);
        String productName = salesService.addSales(salesDTOSave);
        return productName;
    }







}

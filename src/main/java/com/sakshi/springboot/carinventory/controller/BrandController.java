package com.sakshi.springboot.carinventory.controller;

import com.sakshi.springboot.carinventory.dto.*;
import com.sakshi.springboot.carinventory.service.BrandService;
import com.sakshi.springboot.carinventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping(path = "/save")
    public String saveBrand(@RequestBody BrandDTOSave brandDTOSave) {
        String brandName = brandService.addBrand(brandDTOSave);
        return brandName;
    }

    @GetMapping("/getAllBrand")
    public List<BrandDTO>getAllBrand() {
        List<BrandDTO> allBrand = brandService.getAllBrand();
        return allBrand;
    }

    @PutMapping("/update")
    public String updateBrand(@RequestBody BrandDTOUpdate brandDTOUpdate)
    {
        String Id = brandService.updateBrand(brandDTOUpdate);
        return "update";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteBrand(@PathVariable(value = "id")int id)
    {
        boolean deleteBrand = brandService.deleteBrand(id);
        return "deleted";
    }
}

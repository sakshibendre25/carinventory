package com.sakshi.springboot.carinventory.service;

import com.sakshi.springboot.carinventory.dto.BrandDTO;
import com.sakshi.springboot.carinventory.dto.BrandDTOSave;
import com.sakshi.springboot.carinventory.dto.BrandDTOUpdate;

import java.util.List;

public interface BrandService {
    String addBrand(BrandDTOSave brandDTOSave);

    List<BrandDTO> getAllBrand();

    String updateBrand(BrandDTOUpdate brandDTOUpdate);

    boolean deleteBrand(int id);
}

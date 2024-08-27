package com.sakshi.springboot.carinventory.service.IMPL;

import com.sakshi.springboot.carinventory.dto.BrandDTO;
import com.sakshi.springboot.carinventory.dto.BrandDTOSave;
import com.sakshi.springboot.carinventory.dto.BrandDTOUpdate;
import com.sakshi.springboot.carinventory.dto.CategoryDTO;
import com.sakshi.springboot.carinventory.entity.Brand;
import com.sakshi.springboot.carinventory.entity.Category;
import com.sakshi.springboot.carinventory.repository.BrandRepository;
import com.sakshi.springboot.carinventory.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceIMPL implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public String addBrand(BrandDTOSave brandDTOSave) {

        Brand brand = new Brand(
                brandDTOSave.getBrandName(),
                brandDTOSave.isActive()

        );

        brandRepository.save(brand);
        return brand.getBrandName();
    }

    @Override
    public List<BrandDTO> getAllBrand() {

        List<Brand> getBrand = brandRepository.findAll();
        List<BrandDTO>brandDTOList = new ArrayList<>();
        for(Brand brand: getBrand) {
            BrandDTO brandDTO = new BrandDTO(

                    brand.getBrandId(),
                    brand.getBrandName(),
                    brand.isActive()

            );
            brandDTOList.add(brandDTO);
        }
        return brandDTOList;


    }


    @Override
    public String updateBrand(BrandDTOUpdate brandDTOUpdate) {

        if(brandRepository.existsById(brandDTOUpdate.getBrandId()))
        {
            Brand brand = brandRepository.getById(brandDTOUpdate.getBrandId());
            brand.setBrandName(brandDTOUpdate.getBrandName());
            brand.setActive(brandDTOUpdate.isActive());
            brandRepository.save(brand);
        }
        else {
            System.out.println("Car ID not Exist");
        }



        return "";
    }

    @Override
    public boolean deleteBrand(int id) {

        if(brandRepository.existsById(id)) {
            brandRepository.deleteById(id);
        }

        else
        {
            System.out.println("Brand Id is not Found");
        }


        return false;
    }
}
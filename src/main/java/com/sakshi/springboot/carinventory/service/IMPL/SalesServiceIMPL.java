package com.sakshi.springboot.carinventory.service.IMPL;

import com.sakshi.springboot.carinventory.dto.SalesDTOSave;
import com.sakshi.springboot.carinventory.entity.Sales;
import com.sakshi.springboot.carinventory.entity.SalesDetails;
import com.sakshi.springboot.carinventory.repository.ProductRepository;
import com.sakshi.springboot.carinventory.repository.SalesDetailsRepository;
import com.sakshi.springboot.carinventory.repository.SalesRepository;
import com.sakshi.springboot.carinventory.service.SalesService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class SalesServiceIMPL implements SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private SalesDetailsRepository salesDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public String addSales(SalesDTOSave salesDTOSave) {

        Sales sales = new Sales(

                salesDTOSave.getDate(), salesDTOSave.getTotal()
        );
        salesRepository.save(sales);
        if (salesRepository.existsById(sales.getSalesId())) {
            List<SalesDetails> salesDetails = salesDTOSave.getSalesDTOSave().stream()
                    .map(dto -> {
                        SalesDetails salesDetail = modelMapper.map(dto, SalesDetails.class);
                        salesDetail.setSales(sales);
                        salesDetail.setProducts(productRepository.getById(dto.getProductid()));
                        return salesDetail;
                    }).collect(Collectors.toList());

            if (!salesDetails.isEmpty()) {
                salesDetailsRepository.saveAll(salesDetails);

            }

            return "Sales added successfully!";
        }
        return "";
    }
}
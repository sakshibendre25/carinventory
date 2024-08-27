package com.sakshi.springboot.carinventory.service;

import com.sakshi.springboot.carinventory.dto.ProductDTO;
import com.sakshi.springboot.carinventory.dto.ProductDTOSave;
import com.sakshi.springboot.carinventory.dto.ProductDTOUpdate;

import java.util.List;

public interface ProductService {

    String addProduct(ProductDTOSave productDTOSave);

    List<ProductDTO> getAllProducts();

    String updateProduct(ProductDTOUpdate productDTOUpdate);

    boolean deleteProduct(int id);
}
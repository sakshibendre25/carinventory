package com.sakshi.springboot.carinventory.service.IMPL;

import com.sakshi.springboot.carinventory.dto.ProductDTO;
import com.sakshi.springboot.carinventory.dto.ProductDTOSave;
import com.sakshi.springboot.carinventory.dto.ProductDTOUpdate;
import com.sakshi.springboot.carinventory.entity.Product;
import com.sakshi.springboot.carinventory.repository.BrandRepository;
import com.sakshi.springboot.carinventory.repository.CategoryRepository;
import com.sakshi.springboot.carinventory.repository.ProductRepository;
import com.sakshi.springboot.carinventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public String addProduct(ProductDTOSave productDTOSave) {

        Product product = new Product(
                productDTOSave.getProductname(),
                categoryRepository.getById(productDTOSave.getCatid()),
                brandRepository.getById(productDTOSave.getBrandid()),
                productDTOSave.getPrice(),
                productDTOSave.isActive()

        );


        productRepository.save(product);
        return product.getProductName();


    }

    @Override
    public List<ProductDTO> getAllProducts() {

        List<Product> getProducts = productRepository.findAll();

        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : getProducts) {
            ProductDTO productDTO = new ProductDTO(

                    product.getProductId(),
                    product.getProductName(),
                    product.getCategory(),
                    product.getBrand(),
                    product.getPrice(),
                    product.isActive()
            );

            productDTOList.add(productDTO);


        }


        return productDTOList;
    }

    @Override
    public String updateProduct(ProductDTOUpdate productDTOUpdate) {

        if(productRepository.existsById(productDTOUpdate.getProductid())) {
            Product product = productRepository.getById(productDTOUpdate.getProductid());

            product.setProductName(productDTOUpdate.getProductname());
            product.setCategory(categoryRepository.getById(productDTOUpdate.getCatid()));
            product.setBrand(brandRepository.getById(productDTOUpdate.getBrandid()));
            product.setPrice(productDTOUpdate.getPrice());
            product.setActive(productDTOUpdate.isActive());
            productRepository.save(product);
        }
        else
        {
            System.out.println("Product ID not Exist");
        }

        return "";
    }

    @Override
    public boolean deleteProduct(int id) {

        if(productRepository.existsById(id))
        {
            productRepository.deleteById(id);
        }
        else
        {
            System.out.println("Product Id is not Found");
        }


        return false;
    }
}
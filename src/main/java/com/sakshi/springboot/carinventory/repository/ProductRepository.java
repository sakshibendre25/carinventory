package com.sakshi.springboot.carinventory.repository;

import com.sakshi.springboot.carinventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {



}

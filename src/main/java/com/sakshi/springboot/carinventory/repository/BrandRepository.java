package com.sakshi.springboot.carinventory.repository;

import com.sakshi.springboot.carinventory.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
package com.sakshi.springboot.carinventory.repository;

import com.sakshi.springboot.carinventory.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Integer> {
}

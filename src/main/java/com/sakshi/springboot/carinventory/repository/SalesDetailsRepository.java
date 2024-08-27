package com.sakshi.springboot.carinventory.repository;

import com.sakshi.springboot.carinventory.entity.SalesDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesDetailsRepository extends JpaRepository<SalesDetails,Integer> {
}

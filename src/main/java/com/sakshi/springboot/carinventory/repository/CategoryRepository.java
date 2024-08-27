package com.sakshi.springboot.carinventory.repository;

import com.sakshi.springboot.carinventory.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}

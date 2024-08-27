package com.sakshi.springboot.carinventory.service;

import com.sakshi.springboot.carinventory.dto.CategoryDTO;
import com.sakshi.springboot.carinventory.dto.CategoryDTOSave;
import com.sakshi.springboot.carinventory.dto.CategoryDTOUpdate;

import java.util.List;

public interface CategoryService {
    String addCategory(CategoryDTOSave categoryDTOSave);

    List<CategoryDTO> getAllCategory();

    String updateCategory(CategoryDTOUpdate categoryDTOUpdate);

    boolean deleteCategory(int id);
}
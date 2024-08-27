package com.sakshi.springboot.carinventory.service.IMPL;

import com.sakshi.springboot.carinventory.dto.CategoryDTO;
import com.sakshi.springboot.carinventory.dto.CategoryDTOSave;
import com.sakshi.springboot.carinventory.dto.CategoryDTOUpdate;
import com.sakshi.springboot.carinventory.entity.Category;
import com.sakshi.springboot.carinventory.repository.CategoryRepository;
import com.sakshi.springboot.carinventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceIMPL implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public String addCategory(CategoryDTOSave categoryDTOSave) {

        Category category = new Category(
                categoryDTOSave.getCatname(),
                categoryDTOSave.isActive()

        );

        categoryRepository.save(category);
        return category.getCatname();
    }

    @Override
    public List<CategoryDTO> getAllCategory() {


        List<Category> getCategory = categoryRepository.findAll();

        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for (Category category : getCategory) {
            CategoryDTO categoryDTO = new CategoryDTO(

                    category.getCatid(),
                    category.getCatname(),
                    category.isActive()
            );
            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }

    @Override
    public String updateCategory(CategoryDTOUpdate categoryDTOUpdate) {

        if (categoryRepository.existsById(categoryDTOUpdate.getCatid())) {
            Category category = categoryRepository.getById(categoryDTOUpdate.getCatid());
            category.setCatname(categoryDTOUpdate.getCatname());
            category.setActive(categoryDTOUpdate.isActive());
            categoryRepository.save(category);
        } else {
            System.out.println("Car Id not Exist");
        }

        return null;
    }

    @Override
    public boolean deleteCategory(int id) {

        if(categoryRepository.existsById(id))
        {
            categoryRepository.deleteById(id);
        }
        else
        {
            System.out.println("Car Id is not Found");
        }
        return false;
    }
}
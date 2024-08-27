package com.sakshi.springboot.carinventory.controller;

import com.sakshi.springboot.carinventory.dto.CategoryDTO;
import com.sakshi.springboot.carinventory.dto.CategoryDTOSave;
import com.sakshi.springboot.carinventory.dto.CategoryDTOUpdate;
import com.sakshi.springboot.carinventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/category")

public class  CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path="/save")
    public String saveCategory(@RequestBody CategoryDTOSave categoryDTOSave)
    {
        String catname = categoryService.addCategory(categoryDTOSave);
        return catname;
    }

    @GetMapping("/getAllCategory")
    public List<CategoryDTO> getAllCategory()
    {
        List<CategoryDTO> allCategory = categoryService.getAllCategory();
        return allCategory;
    }

    @PutMapping("/update")
    public String updateCategory(@RequestBody CategoryDTOUpdate categoryDTOUpdate)
    {
        String id = categoryService.updateCategory(categoryDTOUpdate);
           return "updated";

    }

@DeleteMapping(path="/delete/{id}")
public String deleteCategory(@PathVariable(value = "id")int id)
{
    boolean deleteCategory = categoryService.deleteCategory(id);
    return "delete";

}


}
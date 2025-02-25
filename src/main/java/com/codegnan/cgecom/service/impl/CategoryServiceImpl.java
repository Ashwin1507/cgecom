package com.codegnan.cgecom.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegnan.cgecom.model.Category;
import com.codegnan.cgecom.model.Product;
import com.codegnan.cgecom.repositories.CategoryRepository;
import com.codegnan.cgecom.service.iface.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    
    
    @Override
    public Category getCategoryById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        throw new RuntimeException("Category not found with ID: " + id);
    }
    
    

    @Override
    public Category findById(int id) {
        Optional<Category> result = categoryRepository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}

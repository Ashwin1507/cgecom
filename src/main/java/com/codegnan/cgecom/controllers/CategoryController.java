package com.codegnan.cgecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codegnan.cgecom.model.Category;
import com.codegnan.cgecom.service.iface.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Show Category Management Page
    @GetMapping
    public String showCategoryManagement(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category-management";
    }

    // Add New Category
    @PostMapping("/add")
    public String addCategory(@RequestParam String name, @RequestParam String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryService.save(category);
        return "redirect:/categories"; // Refresh page after adding
    }

    // Delete Category
    @PostMapping("/delete")
    public String deleteCategory(@RequestParam int id) {
        categoryService.deleteById(id);
        return "redirect:/categories"; // Refresh page after deleting
    }
    
	
    
    
}

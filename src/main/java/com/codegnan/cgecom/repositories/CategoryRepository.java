package com.codegnan.cgecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegnan.cgecom.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Add custom query methods if needed (optional)
}

package com.codegnan.cgecom.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codegnan.cgecom.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	 // Custom method to get paginated products
    Page<Product> findAll(Pageable pageable);
    Page<Product> findByIsActiveTrue(Pageable pageable); // Fetch only active products for pagination
}

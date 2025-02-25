package com.codegnan.cgecom.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegnan.cgecom.model.Product;
import com.codegnan.cgecom.model.UserHistory;
import com.codegnan.cgecom.repositories.UserHistoryRepository;

@Service
public class RecommendationService {
	  /*
    @Autowired
    private UserHistoryRepository userHistoryRepository;

    public List<Product> recommendProducts(Long userId) {
        // Fetch user history
        List<UserHistory> history = userHistoryRepository.findByUserId(userId);

        
      
        // Example: Recommend products in the most interacted category
        Map<String, Long> categoryCount = history.stream()
            .collect(Collectors.groupingBy(
                h -> h.getProduct().getCategory(), 
                Collectors.counting()
            ));
            
        

        String favoriteCategory = categoryCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("Miscellaneous");

        // Fetch and return recommended products
        return productRepository.findByCategory(favoriteCategory);
        
           
    } */
}

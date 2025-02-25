package com.codegnan.cgecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegnan.cgecom.model.Product;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

   // @Autowired
    //private RecommendationService recommendationService;

	/*
    @GetMapping("/{userId}")
    public List<Product> getRecommendations(@PathVariable Long userId) {
        return recommendationService.recommendProducts(userId);
    }
    */
}

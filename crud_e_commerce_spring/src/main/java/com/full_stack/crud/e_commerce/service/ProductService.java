package com.full_stack.crud.e_commerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.full_stack.crud.e_commerce.model.Product;
import com.full_stack.crud.e_commerce.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}

package com.full_stack.crud.e_commerce.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product product){
        return productRepository.findById(id)
            .map(recordFound -> {
                recordFound.setCode(product.getCode());
                recordFound.setDescription(product.getDescription());
                recordFound.setName(product.getName());
                recordFound.setPrice(product.getPrice());
                recordFound.setStock(product.getStock());
                recordFound.setUrlImage(product.getUrlImage());
                return productRepository.save(recordFound);
            })
            .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }
}

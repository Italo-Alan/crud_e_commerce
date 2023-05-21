package com.full_stack.crud.e_commerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.full_stack.crud.e_commerce.model.Product;
import com.full_stack.crud.e_commerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> listAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }
}

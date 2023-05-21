package com.full_stack.crud.e_commerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
import com.full_stack.crud.e_commerce.model.Store;
import com.full_stack.crud.e_commerce.service.StoreService;


@Validated
@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping
    private List<Store> findAll(){
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    private Optional<Store> findById(@PathVariable Long id){
        return storeService.findById(id);
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByStoreId(@PathVariable Long id) {
        return storeService.getProductsByStoreId(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Store create(@RequestBody Store store){
        return storeService.create(store);
    }

    @PutMapping("/{id}")
    public Store update(@PathVariable Long id, @RequestBody Store store){
        return storeService.update(id, store);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable Long id){
        storeService.delete(id);
    }
}

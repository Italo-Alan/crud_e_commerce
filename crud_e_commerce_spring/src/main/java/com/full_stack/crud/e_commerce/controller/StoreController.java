package com.full_stack.crud.e_commerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.full_stack.crud.e_commerce.model.Store;
import com.full_stack.crud.e_commerce.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping("")
    private List<Store> findAll(){
        return storeService.findAll();
    }
}

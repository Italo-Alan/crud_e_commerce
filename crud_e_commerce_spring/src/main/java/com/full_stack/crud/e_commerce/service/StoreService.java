package com.full_stack.crud.e_commerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.full_stack.crud.e_commerce.model.Store;
import com.full_stack.crud.e_commerce.repository.StoreRepository;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    public List<Store> findAll(){
        return storeRepository.findAll();
    }
}

package com.full_stack.crud.e_commerce.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Store> findById(Long id){
        return storeRepository.findById(id);
    }

    public Store create(Store store){
        return storeRepository.save(store);
    }

    public void delete(Long id){
        storeRepository.deleteById(id);
    }
}

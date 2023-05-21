package com.full_stack.crud.e_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.full_stack.crud.e_commerce.model.Product;
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

    public List<Product> getProductsByStoreId(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));

        return store.getProducts();
    }


    public Store update(Long id, Store store){
        return storeRepository.findById(id)
            .map(recordFound -> {
                recordFound.setName(store.getName());
                recordFound.setCnpj(store.getCnpj());
                recordFound.setLineOfBusiness(store.getLineOfBusiness());
                return storeRepository.save(recordFound);
            })
            .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    } 

    public void delete(Long id){
        storeRepository.deleteById(id);
    }
}

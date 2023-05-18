package com.full_stack.crud.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.full_stack.crud.e_commerce.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{
    
}

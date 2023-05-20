package com.full_stack.crud.e_commerce.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 100, nullable = false)
    public String name;

    @Column(length = 14, nullable = false)
    public String cnpj;

    @Column(length = 30, nullable = false)
    public String lineOfBusiness;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy= "store")
    private List<Product> products = new ArrayList<>();
}

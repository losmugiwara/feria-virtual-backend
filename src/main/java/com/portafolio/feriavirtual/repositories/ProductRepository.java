package com.portafolio.feriavirtual.repositories;

import com.portafolio.feriavirtual.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    
    
}

package com.portafolio.feriavirtual.repositories;

import com.portafolio.feriavirtual.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    
}

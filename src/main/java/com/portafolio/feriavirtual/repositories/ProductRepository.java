package com.portafolio.feriavirtual.repositories;

import com.portafolio.feriavirtual.entities.Product;
import com.portafolio.feriavirtual.security.entities.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByUser(User user);
}

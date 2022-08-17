package com.portafolio.feriavirtual.services;

import com.portafolio.feriavirtual.entities.Product;
import com.portafolio.feriavirtual.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return (List<Product>) productRepository.findAll();
    }

    public void create(Product product){
        productRepository.save(product);
    }



}

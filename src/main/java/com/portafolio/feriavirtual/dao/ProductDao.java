package com.portafolio.feriavirtual.dao;

import java.util.List;
import java.util.Optional;

import com.portafolio.feriavirtual.dto.ProductDto;
import com.portafolio.feriavirtual.entities.Product;

public interface ProductDao {
    List<Product> getProducts();
    Optional<Product> getProductById(Long idProduct);
    Product saveProduct(ProductDto productDto, Long userId, Long categoryId, Long qualityId);
    Optional<Product> updateProductById(Long idProduct, Product product);
    void deleteProductById(Long idProduct);
}

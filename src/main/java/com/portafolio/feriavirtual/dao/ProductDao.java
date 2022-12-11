package com.portafolio.feriavirtual.dao;

import java.util.List;
import java.util.Optional;

import com.portafolio.feriavirtual.dto.ProductDto;
import com.portafolio.feriavirtual.entities.Product;

public interface ProductDao {
    List<Product> getProducts();
    Optional<Product> getProductById(Long idProduct);
    Product saveProduct(ProductDto productDto, Long userId, Long categoryId, Long qualityId);
    Product updateProductById(Long idProduct, ProductDto productDto, Long idQuality);
    void deleteProductById(Long idProduct);
    List<Product> getProductsByUser(Long idUser);
}

package com.portafolio.feriavirtual.services;

import com.portafolio.feriavirtual.dao.ProductDao;
import com.portafolio.feriavirtual.dto.ProductDto;
import com.portafolio.feriavirtual.entities.Category;
import com.portafolio.feriavirtual.entities.Product;
import com.portafolio.feriavirtual.entities.Quality;
import com.portafolio.feriavirtual.repositories.CategoryRepository;
import com.portafolio.feriavirtual.repositories.ProductRepository;

import com.portafolio.feriavirtual.repositories.QualityRepository;
import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private QualityRepository qualityRepository;

    @Override
    public void deleteProductById(Long idProduct) {
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<Product> getProductById(Long idProduct) {
        Optional<Product> productOptional = productRepository.findById(idProduct);

        if (productOptional.isPresent()) {
            return productOptional;
        }

        return Optional.empty();
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product saveProduct(ProductDto productDto, Long userId, Long categoryId, Long qualityId) {

        User user = null;
        Category category = null;
        Quality quality = null;
        Product product = new Product();

        Optional<User> userOptional = userRepository.findUserById(userId);
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        Optional<Quality> qualityOptional = qualityRepository.findById(qualityId);

        if (!userOptional.isPresent()) {
            System.out.println("no encontro el usuario");
            return null;
        }

        if (!qualityOptional.isPresent()) {
            System.out.println("no encontro la calidad");
            return null;
        }

        if (!categoryOptional.isPresent()) {
            System.out.println("no se encontro la categoria");
            return null;
        }

        user = userOptional.get();
        category = categoryOptional.get();
        quality = qualityOptional.get();

        product.setNameProduct(productDto.getNameProduct());
        product.setStock(productDto.getStock());
        product.setPrice(productDto.getPrice());
        product.setUrlImage(productDto.getUrlImage());
        product.setKilogram(productDto.getKilogram());

        if (product.getPrice() <= 0) {
            return null;
        }

        if (product.getStock() == 0) {
            product.setProductState(0);
        }

        if (product.getStock() == 0) {
            return null;
        }

        product.setProductState(1);
        product.setCategory(category);
        product.setUser(user);
        product.setQuality(quality);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> updateProductById(Long idProduct, Product product) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<Product> getProductsByUser(Long idUser) {
       
        Optional<User> uo = userRepository.findById(idUser);

        if (!uo.isPresent()) return null;
       
        User user = uo.get();

        return productRepository.findByUser(user);
    }

}

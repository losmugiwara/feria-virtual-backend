package com.portafolio.feriavirtual.controllers;

import java.util.List;

import javax.validation.Valid;

import com.portafolio.feriavirtual.dao.ProductDao;
import com.portafolio.feriavirtual.dto.ProductDto;
import com.portafolio.feriavirtual.entities.Message;

import com.portafolio.feriavirtual.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> foundProducts = productDao.getProducts();
        return new ResponseEntity<>(foundProducts, HttpStatus.OK);
    }

    @GetMapping("/user={idUser}")
    public ResponseEntity<List<Product>> getProductsByUser(@PathVariable Long idUser){
        List<Product> foundProducts = productDao.getProductsByUser(idUser);
        return new ResponseEntity<>(foundProducts, HttpStatus.OK);
    }

    @GetMapping("/product={productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId){
        return ResponseEntity.status(HttpStatus.OK).body(productDao.getProductById(productId));
    }
    @PreAuthorize("hasAnyRole('ROLE_PRODUCER', 'ROLE_ADMIN')")
    @PostMapping("/user={userId}/category={categoryId}/quality={qualityId}")
    public ResponseEntity<?> save(@Valid @RequestBody ProductDto productDto, @PathVariable Long userId, @PathVariable Long categoryId, @PathVariable Long qualityId, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Los campos ingresados son incorrectos"), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.CREATED).body(productDao.saveProduct(productDto, userId, categoryId, qualityId));
    }

    @PreAuthorize("hasAnyRole('ROLE_PRODUCER', 'ROLE_ADMIN')")
    @PutMapping("/productId={productId}/quality={qualityId}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable Long productId, @PathVariable Long qualityId, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Los campos ingresados son incorrectos"), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.CREATED).body(productDao.updateProductById(productId, productDto, qualityId));
    }




}

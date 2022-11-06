package com.portafolio.feriavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.feriavirtual.dao.SaleDao;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleDao saleDao;

    @GetMapping
    public ResponseEntity<?> getSales(){
        return ResponseEntity.status(HttpStatus.OK).body(saleDao.getSales());
    }

    @PutMapping("/sale={saleId}")
    public ResponseEntity<?> updateShippingStatusById(@PathVariable Long saleId, @RequestBody String shippingStatus){
        return ResponseEntity.status(HttpStatus.OK).body(saleDao.updateShippingStatusById(saleId, shippingStatus));
    }


}

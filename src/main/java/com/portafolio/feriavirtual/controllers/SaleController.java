package com.portafolio.feriavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    // @GetMapping("/{idCustomer}")
    // public ResponseEntity



}

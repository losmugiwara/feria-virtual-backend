package com.portafolio.feriavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.feriavirtual.dao.SaleDao;


@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class SaleController {

    @Autowired
    private SaleDao saleDao;

    @GetMapping
    public ResponseEntity<?> getSales(){
        return ResponseEntity.status(HttpStatus.OK).body(saleDao.getSales());
    }

    @GetMapping("/carrier={idCarrier}")
    public ResponseEntity<?> getSalesByCarrier(@PathVariable Long idCarrier){
        return ResponseEntity.status(HttpStatus.OK).body(saleDao.getSalesByCarrierId(idCarrier));
    }

    @PutMapping("/sale={saleId}/status={saleStatusEnum}")
    public ResponseEntity<?> updateShippingStatusById(@PathVariable Long saleId, @PathVariable Integer saleStatusEnum){
        return ResponseEntity.status(HttpStatus.OK).body(saleDao.updateShippingStatusById(saleId, saleStatusEnum));
    }




}

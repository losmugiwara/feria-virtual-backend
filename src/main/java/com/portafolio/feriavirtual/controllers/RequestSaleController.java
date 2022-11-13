package com.portafolio.feriavirtual.controllers;

import com.portafolio.feriavirtual.dao.RequestSaleDao;
import com.portafolio.feriavirtual.dto.RequestSaleDto;
import com.portafolio.feriavirtual.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/request-sale")
public class RequestSaleController {

    @Autowired
    private RequestSaleDao requestSaleDao;

    @GetMapping
    public ResponseEntity<?> getRequestsSale(){
        return ResponseEntity.status(HttpStatus.OK).body(requestSaleDao.getRequestsSale());
    }

    @GetMapping("/{requestSaleId}")
    public ResponseEntity<?> getRequestSale(@PathVariable Long requestSaleId){
        return ResponseEntity.status(HttpStatus.OK).body(requestSaleDao.getRequestSale(requestSaleId));
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<?> saveRequestSale(@Valid @RequestBody RequestSaleDto requestSaleDto, @PathVariable Long customerId, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Los campos ingresados son incorrectos"), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.CREATED).body(requestSaleDao.saveRequestSale(requestSaleDto, customerId));
    }
}

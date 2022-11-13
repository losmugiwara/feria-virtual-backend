package com.portafolio.feriavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.feriavirtual.dao.ContractDao;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractDao contractDao;

    @GetMapping
    public ResponseEntity<?> getContracts(){
        return ResponseEntity.status(HttpStatus.OK).body(contractDao.getContracts());
    }

}

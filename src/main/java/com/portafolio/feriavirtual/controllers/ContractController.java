package com.portafolio.feriavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.feriavirtual.dao.ContractDao;

@RestController
@RequestMapping("/api/contracts")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ContractController {

    @Autowired
    private ContractDao contractDao;

    @GetMapping
    public ResponseEntity<?> getContracts(){
        return ResponseEntity.status(HttpStatus.OK).body(contractDao.getContracts());
    }

    @GetMapping("/{idContract}")
    public ResponseEntity<?> getContractById(@PathVariable Long idContract){
        return ResponseEntity.status(HttpStatus.OK).body(contractDao.getContractById(idContract));

    }


}

package com.portafolio.feriavirtual.controllers;

import com.portafolio.feriavirtual.entities.Contract;
import com.portafolio.feriavirtual.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Contract> getAllContracts(){
        return contractService.getAllContracts();
    }


    @GetMapping("/{idCustomer}")
    public List<Contract> getContractsByIdCustomer(@PathVariable Long idCustomer){
        return contractService.getContractByIdCustomer(idCustomer);
    }

    @GetMapping("/{idProducer}")
    public List<Contract> getContractsByIdProducer(@PathVariable Long idProducer){
        return contractService.getContractByIdProducer(idProducer);
    }

}

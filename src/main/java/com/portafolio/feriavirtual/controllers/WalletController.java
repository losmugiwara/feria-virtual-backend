package com.portafolio.feriavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.feriavirtual.dao.WalletDao;
import com.portafolio.feriavirtual.dto.WalletDto;

@RestController
@RequestMapping("/api/wallets")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class WalletController {

    @Autowired
    private WalletDao walletDao;

    @GetMapping("/{idCustomer}")
    public ResponseEntity<?> getWalletByCustomerId(@PathVariable Long idCustomer) {
        return ResponseEntity.status(HttpStatus.OK).body(walletDao.getWallet(idCustomer));
    }

    @PostMapping("/{idCustomer}")
    public ResponseEntity<?> createWalletByCustomerId(@PathVariable Long idCustomer) {
        return ResponseEntity.status(HttpStatus.OK).body(walletDao.createWallet(idCustomer));
    }

    @PutMapping("/{idCustomer}")
    public ResponseEntity<?> updateWalletByCustomerId(@PathVariable Long idCustomer, @RequestBody WalletDto walletDto) {
        return ResponseEntity.status(HttpStatus.OK).body(walletDao.updateWallet(idCustomer, walletDto));
    }
}

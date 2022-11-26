package com.portafolio.feriavirtual.controllers;


import com.portafolio.feriavirtual.dao.AuctionDao;
import com.portafolio.feriavirtual.dto.AuctionDto;
import com.portafolio.feriavirtual.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/auctions")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class AuctionController {

    @Autowired
    private AuctionDao auctionDao;

    @GetMapping
    private ResponseEntity<?> getAuctions(){
        return ResponseEntity.status(HttpStatus.OK).body(auctionDao.getAuctions());
    }

    @GetMapping("/{auctionId}")
    public ResponseEntity<?> getAuctionById(@PathVariable Long auctionId){
        return ResponseEntity.status(HttpStatus.OK).body(auctionDao.getAuctionById(auctionId));
    }

    @PostMapping("/{requestSaleId}")
    public ResponseEntity<?> saveAuction(@PathVariable Long requestSaleId){
        return ResponseEntity.status(HttpStatus.CREATED).body(auctionDao.saveAuction(requestSaleId));
    }

    @PutMapping("/auction={auctionId}/carrier={carrierId}")
    public ResponseEntity<?> updateAuctionById(@Valid @RequestBody AuctionDto auctionDto, @PathVariable Long auctionId, @PathVariable Long carrierId, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(new Message("Los campos ingresados son incorrectos"), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.OK).body(auctionDao.updateAuctionById(auctionId, carrierId, auctionDto));
    }
}

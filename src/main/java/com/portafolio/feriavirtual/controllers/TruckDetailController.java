package com.portafolio.feriavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.feriavirtual.dao.TruckDetailDao;
import com.portafolio.feriavirtual.entities.TruckDetail;

@RestController
@RequestMapping("/api/truck-details")
public class TruckDetailController {

    @Autowired
    private TruckDetailDao truckDetailDao;

    @GetMapping
    public ResponseEntity<?> getAllTruckDetails() {
        return ResponseEntity.status(HttpStatus.OK).body(truckDetailDao.getAllTruckDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTruckDetailById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(truckDetailDao.getTruckDetailById(id));
    }

    @PostMapping
    public ResponseEntity<?> createTruckDetail(@RequestBody TruckDetail truckDetail){
        return ResponseEntity.status(HttpStatus.CREATED).body(truckDetailDao.createTruckDetail(truckDetail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTruckDetailById(@PathVariable Long id, @RequestBody TruckDetail truckDetail){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }    

}

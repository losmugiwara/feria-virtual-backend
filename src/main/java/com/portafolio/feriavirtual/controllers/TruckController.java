package com.portafolio.feriavirtual.controllers;

import java.util.List;
import java.util.Optional;

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

import com.portafolio.feriavirtual.dao.TruckDao;
import com.portafolio.feriavirtual.entities.Truck;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {
    
    @Autowired
    private TruckDao truckDao;

    @GetMapping
    public List<Truck> getAllTrucks(){
        return truckDao.getAllTrucks();
    }

    @GetMapping("/{id}")
    public Optional<Truck> getTruckById(@PathVariable Long id){
        return truckDao.getTruckById(id);
    }

    @PostMapping
    public Truck createTruck(@RequestBody Truck truck){
        return truckDao.createTruck(truck);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTruckById(@PathVariable Long id, @RequestBody Truck truck){
        truckDao.updateTruckById(id, truck);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    

}

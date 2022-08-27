package com.portafolio.feriavirtual.dao;

import java.util.List;
import java.util.Optional;

import com.portafolio.feriavirtual.entities.Truck;

public interface TruckDao {
    List<Truck> getAllTrucks();
    Optional<Truck> getTruckById(Long id);
    Truck createTruck (Truck truck);
    void updateTruckById(Long id, Truck truck);
}

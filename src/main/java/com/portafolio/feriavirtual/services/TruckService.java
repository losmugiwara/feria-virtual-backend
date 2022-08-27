package com.portafolio.feriavirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.feriavirtual.dao.TruckDao;
import com.portafolio.feriavirtual.entities.Truck;
import com.portafolio.feriavirtual.repositories.TruckRepository;

@Service
public class TruckService implements TruckDao{

    @Autowired
    private TruckRepository truckRepository;

    @Override
    public List<Truck> getAllTrucks() {
        return (List<Truck>) truckRepository.findAll();
    }

    @Override
    public Optional<Truck> getTruckById(Long id) {
        Optional<Truck> truckOptional = truckRepository.findById(id);

        if (!truckOptional.isPresent())
            return Optional.empty();

        return truckOptional;
    }

    @Override
    public Truck createTruck(Truck truck) {
        return truckRepository.save(truck);
    }

    @Override
    public void updateTruckById(Long id, Truck truck) {
        Optional<Truck> truckOptional = truckRepository.findById(id);

        if (truckOptional.isPresent()){
            Truck truckToUpdate = truckOptional.get();
    
            truckRepository.save(truckToUpdate);
        }
    }


}

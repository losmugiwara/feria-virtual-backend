package com.portafolio.feriavirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.feriavirtual.dao.TruckDetailDao;
import com.portafolio.feriavirtual.entities.TruckDetail;
import com.portafolio.feriavirtual.repositories.TruckDetailRepository;

@Service
public class TruckDetailService implements TruckDetailDao {

    @Autowired
    private TruckDetailRepository truckDetailRepository;

    @Override
    public List<TruckDetail> getAllTruckDetails() {
        return (List<TruckDetail>) truckDetailRepository.findAll();
    }

    @Override
    public Optional<TruckDetail> getTruckDetailById(Long id) {
        
        Optional<TruckDetail> truckDetailOptional = truckDetailRepository.findById(id);

        if (truckDetailOptional.isPresent()) {
            return truckDetailOptional;
        }

        return Optional.empty();
    }

    @Override
    public TruckDetail createTruckDetail(TruckDetail truckDetail) {
        return truckDetailRepository.save(truckDetail);
    }

    @Override
    public void updateTruckDetailById(Long id, TruckDetail truckDetail) {
        
        Optional<TruckDetail> truckDetailOptional = truckDetailRepository.findById(id);

        if (truckDetailOptional.isPresent()) {
            truckDetailOptional.get().setUseDate(truckDetail.getUseDate());
            truckDetailOptional.get().setDestiny(truckDetail.getDestiny());
            truckDetailOptional.get().setIdSale(truckDetail.getIdSale());
            truckDetailOptional.get().setIdTruck(truckDetail.getIdTruck());


            TruckDetail truckDetailToUpdate;

            truckDetailToUpdate = truckDetailOptional.get();

            truckDetailRepository.save(truckDetailToUpdate);

        }
    }

    
}
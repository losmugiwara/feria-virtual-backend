package com.portafolio.feriavirtual.dao;

import java.util.List;
import java.util.Optional;
import com.portafolio.feriavirtual.entities.TruckDetail;

public interface TruckDetailDao {
    List<TruckDetail> getAllTruckDetails(); 
    Optional<TruckDetail> getTruckDetailById(Long id);
    TruckDetail createTruckDetail(TruckDetail truck);
    void updateTruckDetailById(Long id, TruckDetail truckDetail);
}

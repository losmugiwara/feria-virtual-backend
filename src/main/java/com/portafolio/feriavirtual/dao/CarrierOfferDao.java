package com.portafolio.feriavirtual.dao;

import com.portafolio.feriavirtual.dto.CarrierOfferDto;
import com.portafolio.feriavirtual.entities.CarrierOffer;

public interface CarrierOfferDao {
    CarrierOffer saveCarrierOffer(CarrierOfferDto carrierOfferDto, Long userId);
}

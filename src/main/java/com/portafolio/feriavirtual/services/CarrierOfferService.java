package com.portafolio.feriavirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.feriavirtual.dao.CarrierOfferDao;
import com.portafolio.feriavirtual.dto.CarrierOfferDto;
import com.portafolio.feriavirtual.entities.CarrierOffer;
import com.portafolio.feriavirtual.repositories.CarrierOfferRepository;
import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.respositories.UserRepository;

@Service
public class CarrierOfferService implements CarrierOfferDao{
    
    @Autowired
    private CarrierOfferRepository carrierOfferRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CarrierOffer saveCarrierOffer(CarrierOfferDto carrierOfferDto, Long userId) {
        
        Optional<User> userOptional = userRepository.findUserById(userId);

        if(!userOptional.isPresent()){
            return null;
        }
       
        User user = userOptional.get();

        CarrierOffer carrierOffer = new CarrierOffer();
        carrierOffer.setUser(user);
        carrierOffer.setOffer(carrierOfferDto.getOffer());

        return carrierOfferRepository.save(carrierOffer);
    }
    
}
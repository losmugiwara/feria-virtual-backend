package com.portafolio.feriavirtual.services;

import com.portafolio.feriavirtual.dao.QualityDao;
import com.portafolio.feriavirtual.entities.Quality;
import com.portafolio.feriavirtual.repositories.QualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualityService implements QualityDao {

    @Autowired
    private QualityRepository qualityRepository;

    @Override
    public List<Quality> getQualities() {
        return (List<Quality>) qualityRepository.findAll();
    }

    @Override
    public Optional<Quality> getQualityById(Long qualityId) {

        Optional<Quality> qualityOptional = qualityRepository.findById(qualityId);

        if(qualityOptional.isPresent()){
            return qualityOptional;
        }

        return Optional.empty();
    }

    @Override
    public Quality saveQuality(Quality quality) {
        return qualityRepository.save(quality);
    }
}

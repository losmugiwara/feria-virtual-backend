package com.portafolio.feriavirtual.dao;

import com.portafolio.feriavirtual.entities.Quality;

import java.util.List;
import java.util.Optional;

public interface QualityDao {

    List<Quality> getQualities();
    Optional<Quality> getQualityById(Long qualityId);
    Quality saveQuality(Quality quality);

}

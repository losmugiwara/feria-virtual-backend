package com.portafolio.feriavirtual.controllers;

import com.portafolio.feriavirtual.dao.QualityDao;
import com.portafolio.feriavirtual.entities.Quality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qualities")
public class QualityController {

    @Autowired
    private QualityDao qualityDao;

    @GetMapping
    public ResponseEntity<?> getQualities(){
        return ResponseEntity.status(HttpStatus.OK).body(qualityDao.getQualities());
    }

    @GetMapping("/quality={qualityId}")
    public ResponseEntity<?> getQuality(@PathVariable Long qualityId){
        return ResponseEntity.status(HttpStatus.OK).body(qualityDao.getQualityById(qualityId));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> saveQuality(@RequestBody Quality quality){
        return ResponseEntity.status(HttpStatus.CREATED).body(qualityDao.saveQuality(quality));
    }
}

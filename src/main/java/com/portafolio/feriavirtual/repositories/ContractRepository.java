package com.portafolio.feriavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portafolio.feriavirtual.entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    
}

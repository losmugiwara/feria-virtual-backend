package com.portafolio.feriavirtual.dao;

import java.util.List;
import java.util.Optional;

import com.portafolio.feriavirtual.entities.Contract;

public interface ContractDao {
    List<Contract> getContracts();
    Optional<Contract> getContractById(Long idContract);
}

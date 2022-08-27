package com.portafolio.feriavirtual.dao;

import java.util.List;

import com.portafolio.feriavirtual.entities.Contract;

public interface ContractDao {
    List<Contract> getAllContracts();
    List<Contract> getContractByIdCustomer(Long id);
    List<Contract> getContractByIdProducer(Long id);
    Contract createContract(Contract contract);

}



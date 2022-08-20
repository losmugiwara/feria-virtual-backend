package com.portafolio.feriavirtual.repositories;

import com.portafolio.feriavirtual.entities.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Long> {

    List<Contract> getContractsByIdCustomer(Long idCustomer);
    List<Contract> getContractsByIdProducer(Long idProducer);
}

package com.portafolio.feriavirtual.services;

import com.portafolio.feriavirtual.entities.Contract;
import com.portafolio.feriavirtual.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;


    public List<Contract> getAllContracts(){
        return (List<Contract>) contractRepository.findAll();
    }

    public List<Contract> getContractByIdCustomer(Long idCustomer){
        return (List<Contract>) contractRepository.getContractsByIdCustomer(idCustomer);
    }

    public List<Contract> getContractByIdProducer(Long idProducer){
        return (List<Contract>) contractRepository.getContractsByIdProducer(idProducer);
    }

    public void saveContract(Contract contract){
        contractRepository.save(contract);
    }

}

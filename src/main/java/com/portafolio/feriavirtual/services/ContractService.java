package com.portafolio.feriavirtual.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.feriavirtual.dao.ContractDao;
import com.portafolio.feriavirtual.entities.Contract;
import com.portafolio.feriavirtual.repositories.ContractRepository;

@Service
public class ContractService implements ContractDao {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> getContracts() {
        return (List<Contract>) contractRepository.findAll();
    }
    
}

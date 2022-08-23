package com.portafolio.feriavirtual.services;

import com.portafolio.feriavirtual.dao.ContractDao;
import com.portafolio.feriavirtual.entities.Contract;
import com.portafolio.feriavirtual.repositories.ContractRepository;
import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements ContractDao{

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Contract> getAllContracts() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public List<Contract> getContractByIdCustomer(Long id) {

        return (List<Contract>) contractRepository.getContractsByIdCustomer(id);
    }

    @Override
    public List<Contract> getContractByIdProducer(Long id) {
        return (List<Contract>) contractRepository.getContractsByIdProducer(id);
    }

    @Override
    public Contract createContract(Contract contract) {
        
        Optional<User> userCustomerOptional = userRepository.findUserById(contract.getIdCustomer());
        Optional<User> userProducerOptional = userRepository.findUserById(contract.getIdProducer());

        if(!userCustomerOptional.isPresent()){
            return null;
        }

        if(!userProducerOptional.isPresent()){
            return null;
        }

        Contract newContract = new Contract();

        newContract.setIdCustomer(userCustomerOptional.get().getId());
        newContract.setIdProducer(userProducerOptional.get().getId());
        newContract.setProducts(contract.getProducts());
        newContract.setCount(contract.getCount());
        newContract.setAddress(contract.getAddress());

        return contractRepository.save(newContract);
    }






}

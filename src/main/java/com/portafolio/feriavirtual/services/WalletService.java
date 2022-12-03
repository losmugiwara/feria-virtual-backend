package com.portafolio.feriavirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.feriavirtual.dao.WalletDao;
import com.portafolio.feriavirtual.dto.WalletDto;
import com.portafolio.feriavirtual.entities.Wallet;
import com.portafolio.feriavirtual.repositories.WalletRepository;
import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.respositories.UserRepository;

@Service
public class WalletService implements WalletDao{

    @Autowired
    private UserRepository ur;

    @Autowired
    private WalletRepository wr;

    @Override
    public Wallet createWallet(Long idCustomer) {

        Optional<User> userOptional = ur.findById(idCustomer);

        if(!userOptional.isPresent()){
            return null;
        }

        User customer = userOptional.get();

        Wallet wallet = new Wallet();
        wallet.setCustomer(customer);

        return wr.save(wallet);
    }

    @Override
    public Wallet updateWallet(Long idCustomer, WalletDto wallerDto) {
        Optional<User> userOptional = ur.findById(idCustomer);

        if(!userOptional.isPresent()){
            return null;
        }

        User customer = userOptional.get();

        Wallet wallet = wr.getWalletByCustomerId(customer.getId());
        wallet.setAmount(wallerDto.getAmount());
        return wr.save(wallet);
    }

    @Override
    public Wallet getWallet(Long idCustomer) {
        Optional<User> userOptional = ur.findById(idCustomer);

        if(!userOptional.isPresent()){
            return null;
        }

        User customer = userOptional.get();

        Wallet wallet = wr.getWalletByCustomerId(customer.getId());

        if (wallet == null) return null;
    
        return wallet;
    }
    
}

package com.portafolio.feriavirtual.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portafolio.feriavirtual.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{
    Wallet getWalletByCustomerId(Long idCustomer);
}

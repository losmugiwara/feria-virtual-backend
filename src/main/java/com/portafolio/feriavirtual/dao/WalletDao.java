package com.portafolio.feriavirtual.dao;

import com.portafolio.feriavirtual.dto.WalletDto;
import com.portafolio.feriavirtual.entities.Wallet;

public interface WalletDao {
    Wallet getWallet(Long idCustomer);
    Wallet createWallet(Long idCustomer);
    Wallet updateWallet(Long idCustomer, WalletDto wallerDto);
}

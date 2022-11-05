package com.portafolio.feriavirtual.repositories;

import com.portafolio.feriavirtual.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> getSalesByCustomerId(Long customerId);
    List<Sale> getSalesByCarrierId(Long carrierId);
}

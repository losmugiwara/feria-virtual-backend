package com.portafolio.feriavirtual.dao;

import java.util.List;

import com.portafolio.feriavirtual.dto.SaleDto;
import com.portafolio.feriavirtual.entities.Sale;

public interface SaleDao {
    List<SaleDto> getAllSales();
    SaleDto getSaleById(Long id);
    SaleDto createSale(Sale sale);
    void updateSaleById(Long id, Sale sale);

}

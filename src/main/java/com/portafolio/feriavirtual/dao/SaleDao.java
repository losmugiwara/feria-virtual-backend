package com.portafolio.feriavirtual.dao;

import com.portafolio.feriavirtual.dto.SaleDto;
import com.portafolio.feriavirtual.entities.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleDao {
    List<Sale> getSales();
    List<Sale> getSalesByCustomerId(Long customerId);
    List<?> getSalesByCarrierId(Long carrierId);
    Optional<Sale> getSaleById(Long saleId);
    Sale saveSale(SaleDto saleDto, Long requestSaleId, Long carrierId);
    Optional<Sale> updateSaleById(Long saleId, SaleDto saleDto);
    Sale updateShippingStatusById(Long saleId, Integer saleStatusEnum);
}

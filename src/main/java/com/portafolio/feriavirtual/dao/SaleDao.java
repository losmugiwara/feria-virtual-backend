package com.portafolio.feriavirtual.dao;

import com.portafolio.feriavirtual.dto.SaleDto;
import com.portafolio.feriavirtual.entities.Sale;
import com.portafolio.feriavirtual.entities.enums.SaleStatusEnum;

import java.util.List;
import java.util.Optional;

public interface SaleDao {
    List<Sale> getSales();
    List<Sale> getSalesByCustomerId(Long customerId);
    Optional<Sale> getSaleById(Long saleId);
    Sale saveSale(SaleDto saleDto, Long requestSaleId, Long carrierId);
    Optional<Sale> updateSaleById(Long saleId, SaleDto saleDto);
    Sale updateShippingStatusById(Long saleId, SaleStatusEnum shippingStatus);
}

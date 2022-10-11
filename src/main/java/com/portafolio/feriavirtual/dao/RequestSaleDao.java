package com.portafolio.feriavirtual.dao;

import com.portafolio.feriavirtual.dto.RequestSaleDto;
import com.portafolio.feriavirtual.entities.RequestSale;

import java.util.List;
import java.util.Optional;

public interface RequestSaleDao {
    List<RequestSale> getRequestsSale();
    Optional<RequestSale> getRequestSale(Long requestSaleId);
    RequestSale saveRequestSale(RequestSaleDto requestSaleDto, Long userId);
}

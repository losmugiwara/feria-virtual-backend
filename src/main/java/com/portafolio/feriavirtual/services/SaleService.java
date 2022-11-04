package com.portafolio.feriavirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.portafolio.feriavirtual.dao.SaleDao;
import com.portafolio.feriavirtual.dto.SaleDto;
import com.portafolio.feriavirtual.entities.Sale;
import com.portafolio.feriavirtual.entities.enums.SaleStatusEnum;
import com.portafolio.feriavirtual.repositories.SaleRepository;

public class SaleService implements SaleDao{

    @Autowired
    private SaleRepository saleRepository;


    @Override
    public List<Sale> getSales() {
        return (List<Sale>) saleRepository.findAll();
    }

    @Override
    public List<Sale> getSalesByCustomerId(Long customerId) {
        
        return (List<Sale>) saleRepository.getSalesByCustomerId(customerId);
    }

    @Override
    public Optional<Sale> getSaleById(Long saleId) {

        Optional<Sale> saleOptional = saleRepository.findById(saleId);

        if(!saleOptional.isPresent()){
            return null;
        }

        return saleOptional;
    }

    @Override
    public Sale saveSale(SaleDto saleDto, Long requestSaleId, Long carrierId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Sale> updateSaleById(Long saleId, SaleDto saleDto) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Sale updateShippingStatusById(Long saleId, SaleStatusEnum shippingStatus) {
        
        Optional<Sale> saleOptional = saleRepository.findById(saleId);

        if(!saleOptional.isPresent()){
            return null;
        }

        Sale sale = saleOptional.get();

        sale.setSaleStatusEnum(shippingStatus);

        return saleRepository.save(sale);
    }
    
}

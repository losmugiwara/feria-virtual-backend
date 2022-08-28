
package com.portafolio.feriavirtual.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.feriavirtual.dao.SaleDao;
import com.portafolio.feriavirtual.dto.SaleDto;
import com.portafolio.feriavirtual.entities.Contract;
import com.portafolio.feriavirtual.entities.Sale;
import com.portafolio.feriavirtual.repositories.ContractRepository;
import com.portafolio.feriavirtual.repositories.SaleRepository;
import com.portafolio.feriavirtual.repositories.TruckDetailRepository;
import com.portafolio.feriavirtual.repositories.TruckRepository;
import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.respositories.UserRepository;

@Service
public class SaleService implements SaleDao {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private TruckRepository truckRepository;
    @Autowired
    private TruckDetailRepository truckDetailRepository;
    @Autowired
    private UserRepository userRepository; 
    @Autowired
    private ContractRepository contractRepository;



    @Override
    public List<SaleDto> getAllSales() { 
        
        List<SaleDto> saleDtos = new ArrayList<>();

        List<Sale> sales = (List<Sale>) saleRepository.findAll();
        for (Sale sale : sales) {
            SaleDto newSaleDto = new SaleDto();
            User carrier = userRepository.findUserById(sale.getIdCarrier()).get();
            Contract contract = contractRepository.findById(sale.getIdContract()).get();
            
            newSaleDto.setId(sale.getId());
            newSaleDto.setUserCarrier(carrier);
            newSaleDto.setContract(contract);
            newSaleDto.setDateSale(sale.getDateSale());
            newSaleDto.setStateSale(sale.getStateSale());
            saleDtos.add(newSaleDto);
        }
        return saleDtos;
    }

    @Override
    public SaleDto getSaleById(Long id) {
        Optional<Sale> saleOptional = saleRepository.findById(id);

        if(saleOptional.isPresent()){
            Sale saleGet = saleOptional.get();


            SaleDto saleDto = new SaleDto();

            User carrier = userRepository.findUserById(saleGet.getIdCarrier()).get();
            Contract contract = contractRepository.findById(saleGet.getIdContract()).get();

            saleDto.setId(saleGet.getId());
            saleDto.setUserCarrier(carrier);
            saleDto.setContract(contract);
            saleDto.setDateSale(saleGet.getDateSale());
            saleDto.setStateSale(saleGet.getStateSale());
            return saleDto;
        } 

        return null;
    }

    @Override
    public SaleDto createSale(Sale sale) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateSaleById(Long id, Sale sale) {
        // TODO Auto-generated method stub
        
    }
    
}

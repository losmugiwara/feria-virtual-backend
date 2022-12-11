package com.portafolio.feriavirtual.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.portafolio.feriavirtual.dao.SaleDao;
import com.portafolio.feriavirtual.dto.SaleDto;
import com.portafolio.feriavirtual.dto.SalesContractDto;
import com.portafolio.feriavirtual.entities.Contract;
import com.portafolio.feriavirtual.entities.Sale;
import com.portafolio.feriavirtual.entities.enums.SaleStatusEnum;
import com.portafolio.feriavirtual.repositories.ContractRepository;
import com.portafolio.feriavirtual.repositories.SaleRepository;

@Service
public class SaleService implements SaleDao {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

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

        if (!saleOptional.isPresent()) {
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
    public Sale updateShippingStatusById(Long saleId, Integer saleStatusEnum) {

        try {

            Optional<Sale> saleOptional = saleRepository.findById(saleId);

            if (!saleOptional.isPresent()) {
                return null;
            }

            Sale sale = saleOptional.get();

            if (saleStatusEnum == 1) {
                sale.setSaleStatusEnum(SaleStatusEnum.PACKAGE);
            }
            if (saleStatusEnum == 2) {
                sale.setSaleStatusEnum(SaleStatusEnum.DISPATCH_PORT);
            }
            if (saleStatusEnum == 3) {
                sale.setSaleStatusEnum(SaleStatusEnum.IN_TRANSIT);
            }
            if (saleStatusEnum == 4) {
                sale.setSaleStatusEnum(SaleStatusEnum.CUSTOMER_REVISION);
            }
            if (saleStatusEnum == 5) {
                sale.setSaleStatusEnum(SaleStatusEnum.ACCEPTED);
            }
            if (saleStatusEnum == 6) {
                sale.setSaleStatusEnum(SaleStatusEnum.REJECTED);
            }

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(sale.getRequestSale().getUser().getEmail());
            mailMessage.setText("Estado acual del pedido: " + sale.getSaleStatusEnum());
            mailMessage.setSubject("Estado de Venta");

            javaMailSender.send(mailMessage);

            return saleRepository.save(sale);

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<?> getSalesByCarrierId(Long carrierId) {
        List<Sale> sales = saleRepository.getSalesByCarrierId(carrierId);

        List<SalesContractDto> scList = new ArrayList<>();

        for (Sale sale : sales) {

            Contract co = contractRepository.findContractBySaleId(sale.getId());

            SalesContractDto sc = new SalesContractDto();

            sc.setSale(sale);
            sc.setContract(co);

            scList.add(sc);

        }

        // sales.stream().map(s -> {
        // Optional<Sale> so = saleRepository.findById(s.getId());

        // if(!so.isPresent()) return null;

        // Sale sale = so.get();

        // Optional<Contract> co = contractRepository.getContractBySaleId(sale.getId());

        // if(!co.isPresent()) return null;

        // Contract contract = co.get();

        // SalesContractDto sc = new SalesContractDto();

        // sc.setSale(sale);
        // sc.setContract(contract);

        // scList.add(sc);

        // return null;

        // });

        return scList;
    }

}

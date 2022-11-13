package com.portafolio.feriavirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.portafolio.feriavirtual.dao.SaleDao;
import com.portafolio.feriavirtual.dto.SaleDto;
import com.portafolio.feriavirtual.entities.Sale;
import com.portafolio.feriavirtual.entities.enums.SaleStatusEnum;
import com.portafolio.feriavirtual.repositories.SaleRepository;

@Service
public class SaleService implements SaleDao{

    @Autowired
    private SaleRepository saleRepository;

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
    public Sale updateShippingStatusById(Long saleId, SaleStatusEnum saleStatusEnum) {
        
        try {


            System.out.println("shippingStatus ========> " + saleStatusEnum );

            Optional<Sale> saleOptional = saleRepository.findById(saleId);
    
            if(!saleOptional.isPresent()){
                return null;
            }
    
            Sale sale = saleOptional.get();

    
            // SimpleMailMessage mailMessage = new SimpleMailMessage();
            
            // mailMessage.setFrom(sender);
            // mailMessage.setTo(sender);
            // mailMessage.setText("Hola que tal?");
            // mailMessage.setSubject("Test Email From Spring Boot");

            // javaMailSender.send(mailMessage);



            return saleRepository.save(sale);
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
}

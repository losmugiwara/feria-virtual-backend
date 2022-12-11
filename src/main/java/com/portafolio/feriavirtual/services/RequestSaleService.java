package com.portafolio.feriavirtual.services;

import com.portafolio.feriavirtual.dao.RequestSaleDao;
import com.portafolio.feriavirtual.dto.ProductItem;
import com.portafolio.feriavirtual.dto.RequestSaleDto;
import com.portafolio.feriavirtual.entities.Product;
import com.portafolio.feriavirtual.entities.RequestSale;
import com.portafolio.feriavirtual.entities.Wallet;
import com.portafolio.feriavirtual.entities.enums.ApprovalStatusEnum;
import com.portafolio.feriavirtual.repositories.ProductRepository;
import com.portafolio.feriavirtual.repositories.RequestSaleRepository;
import com.portafolio.feriavirtual.repositories.WalletRepository;
import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestSaleService implements RequestSaleDao {

    @Autowired
    private RequestSaleRepository requestSaleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<RequestSale> getRequestsSale() {
        return (List<RequestSale>) requestSaleRepository.findAll();
    }

    @Override
    public Optional<RequestSale> getRequestSale(Long requestSaleId) {

        Optional<RequestSale> requestSaleOptional = requestSaleRepository.findById(requestSaleId);

        if(requestSaleOptional.isPresent()){
            return requestSaleOptional;
        }

        return Optional.empty();
    }

    @Override
    public RequestSale saveRequestSale(RequestSaleDto requestSaleDto, Long userId) {
        User user = null;
        RequestSale rs = new RequestSale();

        Optional<User> userOptional = userRepository.findUserById(userId);

        if (!userOptional.isPresent()){
            return null;
        }

        user = userOptional.get();

        Wallet wo = walletRepository.getWalletByCustomerId(user.getId());

        if(wo == null) return null;

        rs.setUser(user);


        double totalRequest = 0.0;

        List<Product> products = new ArrayList<>();

        for( ProductItem p: requestSaleDto.getProductsItem() ){
            Product prod = productRepository.findById(p.getIdProduct()).orElse(null);
            
            if (p.getCount() > prod.getStock()){
                return null;
            }

            prod.setStock(prod.getStock() - p.getCount());

            totalRequest += p.getCount() * prod.getPrice();
            
            Product productUpdated = productRepository.save(prod);

            products.add(productUpdated);
        }

                
        if (wo.getAmount() < totalRequest){
            return null;
        }

        wo.setAmount(wo.getAmount() - totalRequest);
        walletRepository.save(wo);

        rs.setProducts(products);
        
        rs.setShippingAddress(requestSaleDto.getShippingAddress());

        return requestSaleRepository.save(rs);
    }

    @Override
    public RequestSale updateStatusRequestSaleById(Long requestSaleId, Long approvalStatus) {
        Optional<RequestSale> rsOptional = requestSaleRepository.findById(requestSaleId);

        if(!rsOptional.isPresent()){
            return null;
        }

        RequestSale rs = rsOptional.get();

        if(approvalStatus == 1){
            rs.setApprovalStatus(ApprovalStatusEnum.PASSED);
        }

        if(approvalStatus == 2){
            rs.setApprovalStatus(ApprovalStatusEnum.REFUSED);
        }

        return requestSaleRepository.save(rs);
    }
}

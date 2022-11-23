package com.portafolio.feriavirtual.services;

import com.portafolio.feriavirtual.dao.RequestSaleDao;
import com.portafolio.feriavirtual.dto.RequestSaleDto;
import com.portafolio.feriavirtual.entities.RequestSale;
import com.portafolio.feriavirtual.entities.enums.ApprovalStatusEnum;
import com.portafolio.feriavirtual.repositories.RequestSaleRepository;
import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestSaleService implements RequestSaleDao {

    @Autowired
    private RequestSaleRepository requestSaleRepository;

    @Autowired
    private UserRepository userRepository;

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

        rs.setUser(user);
        rs.setProducts(requestSaleDto.getProducts());
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

        // rs.setApprovalDate(new Date());

        return requestSaleRepository.save(rs);
    }
}

package com.portafolio.feriavirtual.services;

import com.portafolio.feriavirtual.dao.AuctionDao;
import com.portafolio.feriavirtual.dto.AuctionDto;
import com.portafolio.feriavirtual.entities.Auction;
import com.portafolio.feriavirtual.entities.CarrierOffer;
import com.portafolio.feriavirtual.entities.Contract;
import com.portafolio.feriavirtual.entities.Product;
import com.portafolio.feriavirtual.entities.RequestSale;
import com.portafolio.feriavirtual.entities.Sale;
import com.portafolio.feriavirtual.repositories.AuctionRepository;
import com.portafolio.feriavirtual.repositories.CarrierOfferRepository;
import com.portafolio.feriavirtual.repositories.ContractRepository;
import com.portafolio.feriavirtual.repositories.RequestSaleRepository;
import com.portafolio.feriavirtual.repositories.SaleRepository;
import com.portafolio.feriavirtual.security.entities.User;
import com.portafolio.feriavirtual.security.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuctionService implements AuctionDao {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private RequestSaleRepository requestSaleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarrierOfferRepository carrierOfferRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Auction> getAuctions() {
        return (List<Auction>) auctionRepository.findAll();
    }

    @Override
    public Optional<Auction> getAuctionById(Long auctionId) {

        Optional<Auction> auctionOptional = auctionRepository.findById(auctionId);

        if (!auctionOptional.isPresent()) {
            return null;
        }

        return auctionOptional;
    }

    @Override
    public Auction saveAuction(Long requestSaleId) {

        Auction auction = new Auction();

        Optional<RequestSale> requestSaleOptional = requestSaleRepository.findById(requestSaleId);

        if (!requestSaleOptional.isPresent()) {
            return null;
        }

        RequestSale requestSale = requestSaleOptional.get();

        auction.setRequestSale(requestSale);

        return auctionRepository.save(auction);
    }

    @Override
    public Auction updateAuctionById(Long auctionId, Long userId, AuctionDto auctionDto) {

        // transportista
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Auction> auctionOptional = auctionRepository.findById(auctionId);

        if (!userOptional.isPresent()) {
            return null;
        }

        if (!auctionOptional.isPresent()) {
            return null;
        }

        User user = userOptional.get();
        Auction auction = auctionOptional.get();

        CarrierOffer c = new CarrierOffer();

        c.setOffer(auctionDto.getOffer());
        c.setUser(user);

        CarrierOffer carrierOfferSave = carrierOfferRepository.save(c);

        List<CarrierOffer> carrierOffers = auction.getCarrierOffers();

        if (carrierOffers.size() == 5) {

            CarrierOffer co = carrierOffers.stream().min(Comparator.comparingDouble(CarrierOffer::getOffer))
                    .orElseThrow(NoSuchElementException::new);

            Sale sale = new Sale();

            sale.setRequestSale(auction.getRequestSale());

            // obteniendo PRODUCER desde product
            Product product = auction.getRequestSale()
                    .getProducts().get(0);

            User producer = product.getUser();
            User customer = auction.getRequestSale().getUser();
            sale.setProducer(producer);
            sale.setCustomer(customer);
            sale.setCarrier(co.getUser());

            Double totalProducts = auction.getRequestSale().getProducts().stream()
                    .mapToDouble(p -> p.getPrice())
                    .sum();

            sale.setTotalPriceProducts(totalProducts);
            sale.setTotalCarrier(co.getOffer());
            sale.setTotal(sale.getTotalCarrier() + sale.getTotalPriceProducts());

            saleRepository.save(sale);

            //auction end date
            auction.setEndDateAuction(new Date());
            auctionRepository.save(auction);

            // Instancia para contract y relacionarlo con sale
            Contract contract = new Contract();
            contract.setSale(sale);

            contractRepository.save(contract);

            return null;
        }

        carrierOffers.add(carrierOfferSave);
        auction.setCarrierOffers(carrierOffers);

        return auctionRepository.save(auction);
    }
}

package com.portafolio.feriavirtual.dao;

import com.portafolio.feriavirtual.dto.AuctionDto;
import com.portafolio.feriavirtual.entities.Auction;

import java.util.List;
import java.util.Optional;

public interface AuctionDao {
    List<Auction> getAuctions();
    Optional<Auction> getAuctionById(Long auctionId);
    Auction saveAuction(Long requestSaleId);
    Auction updateActiveAuctionById(Long auctionId, Integer active);
    Auction updateAuctionById(Long auctionId, Long userId, AuctionDto auctionDto);
}

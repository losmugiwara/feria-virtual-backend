package com.portafolio.feriavirtual.repositories;

import com.portafolio.feriavirtual.entities.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}

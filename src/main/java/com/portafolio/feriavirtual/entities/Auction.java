package com.portafolio.feriavirtual.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auctions")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private RequestSale requestSale;

    @ManyToMany
    @Null
    private List<CarrierOffer> carrierOffers;

    @Column(name = "start_date_auction")
    @NotNull
    private Date startDateAuction = new Date();

    @Column(name = "end_date_auction")
    @Null
    private Date endDateAuction;

    @Column(name = "active")
    private Integer active = 1;
}

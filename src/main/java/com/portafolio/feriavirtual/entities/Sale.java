package com.portafolio.feriavirtual.entities;

import com.portafolio.feriavirtual.entities.enums.SaleStatusEnum;
import com.portafolio.feriavirtual.security.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
@Table(name = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "request_sale_id")
    @OneToOne
    private RequestSale requestSale;

    @ManyToOne
    @JoinColumn(name = "user_customer_id")
    private User customer;
    
    @ManyToOne
    @JoinColumn(name = "user_producer_id")
    private User producer;

    @ManyToOne
    @JoinColumn(name = "user_carrier_id")
    private User carrier;

    @Column(name = "total_price_products")
    private Double totalPriceProducts;

    @Column(name = "total_carrier")
    private Double totalCarrier;

    @Column(name = "total")
    private Double total;

    @Column(name = "sale_status")
    private SaleStatusEnum saleStatusEnum = SaleStatusEnum.WAREHOUSE;

    @Column(name = "creation_date")
    private Date creationDate = new Date();

    @Column(name = "ending_date")
    @Null
    private Date endingDate;
}

package com.portafolio.feriavirtual.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contracts")
@Getter
@Setter
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contractid_generator")
    @SequenceGenerator(name = "contractid_generator", initialValue = 1, allocationSize = 1, sequenceName = "contractid_seq")
    private Long id;

    @Column(name = "id_customer")
    private String idCustomer;

    @Column(name = "id_producer")
    private String idProducer;

    @OneToMany
    private List<Product> products;

    @Column(name = "count")
    private Integer count;

    @Column(name = "date_init")
    private Date dateInit;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "date_delivery")
    private Date dateDelivery;

    private String address;
}

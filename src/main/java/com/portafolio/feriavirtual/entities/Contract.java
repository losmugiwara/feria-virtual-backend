package com.portafolio.feriavirtual.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contracts")
@Getter
@Setter
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_customer")
    private String idCustomer;

    @Column(name = "id_producer")
    private String idProducer;

    @OneToMany
    private List<Product> products;

    private String address;
}

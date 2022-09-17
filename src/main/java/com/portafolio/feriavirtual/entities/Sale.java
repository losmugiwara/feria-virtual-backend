package com.portafolio.feriavirtual.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saleid_generator")
//    @SequenceGenerator(name = "saleid_generator", initialValue = 1, allocationSize = 1, sequenceName = "saleid_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_contract")
    private Long idContract;
    @Column(name = "id_carrier")
    private Long idCarrier;
    @Column(name = "date_sale")
    private Date dateSale;
    @Column(name = "state_sale")
    private Boolean stateSale;
    
}

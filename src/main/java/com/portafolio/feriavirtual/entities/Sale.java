package com.portafolio.feriavirtual.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

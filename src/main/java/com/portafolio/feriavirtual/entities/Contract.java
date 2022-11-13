package com.portafolio.feriavirtual.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import com.portafolio.feriavirtual.entities.enums.ContractValidity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private Date startDate = new Date();

    @Column(name = "end_date")
    @Null
    private Date endDate;

    @Column(name = "contract_validity")
    private ContractValidity contractValidity = ContractValidity.VALID;

    @JoinColumn(name = "sale_id")
    @OneToOne
    private Sale sale;

}

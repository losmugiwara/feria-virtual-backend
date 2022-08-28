package com.portafolio.feriavirtual.entities;

import java.util.Date;

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
@Table(name = "truck_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TruckDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "truckdetailid_generator")
    @SequenceGenerator(name = "truckdetailid_generator", initialValue = 1, allocationSize = 1, sequenceName = "truckdetailid_seq")
    private Long id;
    private Long idTruck;
    private Long idSale;
    private Date useDate;
    private String destiny;
    
}

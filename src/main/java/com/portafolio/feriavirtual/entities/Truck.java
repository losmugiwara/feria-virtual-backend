package com.portafolio.feriavirtual.entities;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trucks")
public class Truck {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "truckid_generator")
//    @SequenceGenerator(name = "truckid_generator", initialValue = 1, allocationSize = 1, sequenceName = "truckid_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate")
    private String plate;

}

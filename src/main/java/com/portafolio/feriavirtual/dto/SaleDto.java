package com.portafolio.feriavirtual.dto;

import java.util.Date;

import com.portafolio.feriavirtual.entities.Contract;
import com.portafolio.feriavirtual.security.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {

    private Long id;
    private User userCarrier;
    private Contract contract;
    private Date dateSale;
    private Boolean stateSale;
}

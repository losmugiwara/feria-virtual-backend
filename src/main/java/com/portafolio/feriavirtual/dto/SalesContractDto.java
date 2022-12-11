package com.portafolio.feriavirtual.dto;

import com.portafolio.feriavirtual.entities.Contract;
import com.portafolio.feriavirtual.entities.Sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesContractDto {
    
    private Sale sale;
    private Contract contract;

}

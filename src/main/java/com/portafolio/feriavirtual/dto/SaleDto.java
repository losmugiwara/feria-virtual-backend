package com.portafolio.feriavirtual.dto;

import com.portafolio.feriavirtual.entities.enums.SaleStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {
    private String observation;
    private SaleStatusEnum saleStatusEnum;
    private Date endingDate;
}

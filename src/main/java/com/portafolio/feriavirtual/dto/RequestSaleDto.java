package com.portafolio.feriavirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestSaleDto {
    private List<ProductItem> productsItem;
    private String shippingAddress;
}

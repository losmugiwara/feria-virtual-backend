package com.portafolio.feriavirtual.dto;

import com.portafolio.feriavirtual.entities.Product;
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
    private List<Product> products;
    private String shippingAddress;
}

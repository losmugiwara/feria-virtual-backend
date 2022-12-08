package com.portafolio.feriavirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String nameProduct;
    private Double price;
    private Integer stock;
    private String urlImage;
    private Double kilogram;
}

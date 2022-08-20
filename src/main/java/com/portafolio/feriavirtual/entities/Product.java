package com.portafolio.feriavirtual.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodid_generator")
    @SequenceGenerator(name = "prodid_sequence", initialValue = 1, allocationSize = 1, sequenceName = "prodid_seq")
    private Long id;

    @Column(name = "name_product", length = 255, nullable = false)
    private String nameProduct;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "producto_state")
    private Integer productState;

}

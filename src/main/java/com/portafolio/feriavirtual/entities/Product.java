package com.portafolio.feriavirtual.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_product", length = 255, nullable = false)
    private String nameProduct;

    @Column(nullable = false)
    private Integer stock;

    @OneToOne
    @Column(name = "id_category")
    private Category category;

}

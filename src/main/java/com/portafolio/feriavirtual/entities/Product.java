package com.portafolio.feriavirtual.entities;

import com.portafolio.feriavirtual.security.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_product", length = 255, nullable = false)
    private String nameProduct;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Double price;

    @Column(name = "producto_state")
    private Integer productState;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quality_id")
    private Quality quality;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "kilogram")
    private Double kilogram;

}



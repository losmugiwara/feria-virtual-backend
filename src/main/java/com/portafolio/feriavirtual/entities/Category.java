package com.portafolio.feriavirtual.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryid_generator")
    @SequenceGenerator(name = "categoryid_generator", initialValue = 1, allocationSize = 1, sequenceName = "categoryid_seq")
    private Long id;

    @Column(name = "name_category")
    private String nameCategory;



}

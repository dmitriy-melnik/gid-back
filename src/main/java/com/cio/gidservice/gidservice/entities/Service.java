package com.cio.gidservice.gidservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.postgresql.util.PGmoney;

import javax.persistence.*;

@Data
@Entity
@Table(name = "services")
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    //Основные поля сущности Услуга
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private PGmoney price;
    private Integer leadTime; //minutes

    //Связь с заведением
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "establishment_id", nullable = false)
    @JsonIgnore
    private Establishment establishment;

    /*
    * TODO:
    *  1. Add keywords system.
    *  2. Add photo(photos)
    */

}

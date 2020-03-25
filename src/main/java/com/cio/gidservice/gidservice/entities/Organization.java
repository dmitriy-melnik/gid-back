package com.cio.gidservice.gidservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="organization")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    // Основные поля сущности Заведение
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private Float rating;

    @OneToOne(mappedBy = "organization")
    private Location location;

    //Связь между заведением и услугами
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Service> services;

    //Связь с пользователем, которому заведение принадлежит
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    /*
    * TODO:
    *  1. Add keywords system.
    *  2. Add photo
    *  3. Add relation with businessman
    */

}


package com.cio.gidservice.gidservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="establishment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Establishment {

    // Основные поля сущности Заведение
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private Float rating;

    @OneToOne(mappedBy = "establishment")
    private Location location;

    //Связь между заведением и услугами
    @OneToMany(mappedBy = "establishment", cascade = CascadeType.ALL)
    private List<Service> services;

    public void addService(Service service) {
        services.add(service);
    }

    /*
    * TODO:
    *  1. Add keywords system.
    *  2. Add photo
    *  3. Add relation with businessman
    */

}


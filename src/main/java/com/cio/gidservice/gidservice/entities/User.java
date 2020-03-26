package com.cio.gidservice.gidservice.entities;

import com.cio.gidservice.gidservice.entities.databaseEntities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="usr")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String password;
    private UserType userType;
    private String name;

}


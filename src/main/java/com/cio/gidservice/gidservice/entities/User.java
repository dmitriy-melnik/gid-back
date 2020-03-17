package com.cio.gidservice.gidservice.entities;

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
    private Long id;
    private String phoneNumber;
    private String password;
    private UserType userType;
    private String name;

}


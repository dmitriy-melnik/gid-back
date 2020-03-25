package com.cio.gidservice.gidservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="usr")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phoneNumber;
    private String login;
    private String password;
    private boolean isBusinessman;
    private String name;

    //Связь с заведениями, которые принадлежат пользователю
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Organization> organizationList;

    public void addOrganization(Organization organization) {
        organizationList.add(organization);
    }
}


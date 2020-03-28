package com.cio.gidservice.gidservice.entities.databaseEntities;

import com.cio.gidservice.gidservice.entities.databaseEntities.Organization;
import com.cio.gidservice.gidservice.entities.requestEntities.UserRequestEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

/**
 *
 */
@Data
@Entity
@Table(name="usr")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @PositiveOrZero
    private Long id;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String login;
    @NotEmpty
    @Size(min = 6, max = 100, message = "password must be between 6 and 100 characters")
    private String password;
    /*private UserType userType;*/
    @NotEmpty
    private String name;

    //Связь с заведениями, которые принадлежат пользователю
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Organization> organizationList;

    public User(UserRequestEntity entity) {
        this.phoneNumber = entity.getPhoneNumber();
        this.login = entity.getLogin();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.organizationList = entity.getOrganizationList();
    }

    public void addOrganization(Organization organization) {
        organizationList.add(organization);
    }
}


package com.cio.gidservice.gidservice.entities.requestEntities;

import com.cio.gidservice.gidservice.entities.databaseEntities.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRequestEntity extends User {
    @NotEmpty
    private String ip;
}

package com.cio.gidservice.gidservice.entities;

import lombok.ToString;

@ToString
public enum UserType {
    SIMPLE_USER,
    BUSINESS_USER,
    EMPLOYEE,
    MODERATOR
}

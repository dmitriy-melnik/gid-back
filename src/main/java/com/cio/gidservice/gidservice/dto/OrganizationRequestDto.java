package com.cio.gidservice.gidservice.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class OrganizationRequestDto {

    public Long organization_id;

    public String name;

    public String phoneNumber;

    public String email;

    public String website;

    public String description;

    public Float rating;
}

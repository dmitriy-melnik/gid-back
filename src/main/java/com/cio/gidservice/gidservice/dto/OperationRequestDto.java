package com.cio.gidservice.gidservice.dto;

import lombok.Data;


@Data
public class OperationRequestDto {
    public Long operation_id;

    public String name;

    public String description;

    public Float price;

}

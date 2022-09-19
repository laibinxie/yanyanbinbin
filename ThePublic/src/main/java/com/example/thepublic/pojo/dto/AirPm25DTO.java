package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class AirPm25DTO extends BaseDataDTO {
    public AirPm25DTO(String value, String color) {
        super(value, color);
    }

    public AirPm25DTO() {
    }
}

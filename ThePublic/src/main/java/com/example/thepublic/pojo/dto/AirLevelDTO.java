package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class AirLevelDTO extends BaseDataDTO{
    public AirLevelDTO(String value, String color) {
        super(value, color);
    }

    public AirLevelDTO() {
    }
}

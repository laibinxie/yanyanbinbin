package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class AirLevelNameDTO extends BaseDataDTO{
    public AirLevelNameDTO(String value, String color) {
        super(value, color);
    }

    public AirLevelNameDTO() {
    }
}

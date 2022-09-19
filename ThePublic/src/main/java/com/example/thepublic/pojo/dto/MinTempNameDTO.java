package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class MinTempNameDTO extends BaseDataDTO{
    public MinTempNameDTO(String value, String color) {
        super(value, color);
    }

    public MinTempNameDTO() {
    }
}

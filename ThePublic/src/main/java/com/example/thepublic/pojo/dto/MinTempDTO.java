package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class MinTempDTO extends BaseDataDTO{
    public MinTempDTO(String value, String color) {
        super(value, color);
    }

    public MinTempDTO() {
    }
}

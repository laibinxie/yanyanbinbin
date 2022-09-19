package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class MaxTempNameDTO extends BaseDataDTO{
    public MaxTempNameDTO(String value, String color) {
        super(value, color);
    }

    public MaxTempNameDTO() {
    }
}

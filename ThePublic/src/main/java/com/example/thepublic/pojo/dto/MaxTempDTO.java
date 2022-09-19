package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class MaxTempDTO extends BaseDataDTO{
    public MaxTempDTO(String value, String color) {
        super(value, color);
    }

    public MaxTempDTO() {
    }
}

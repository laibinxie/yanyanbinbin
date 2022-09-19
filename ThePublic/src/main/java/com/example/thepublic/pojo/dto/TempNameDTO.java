package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class TempNameDTO extends BaseDataDTO{
    public TempNameDTO(String value, String color) {
        super(value, color);
    }

    public TempNameDTO() {
    }
}

package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class TempDTO extends BaseDataDTO{
    public TempDTO(String value, String color) {
        super(value, color);
    }

    public TempDTO() {
    }
}

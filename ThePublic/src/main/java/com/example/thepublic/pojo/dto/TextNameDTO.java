package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class TextNameDTO extends BaseDataDTO{
    public TextNameDTO(String value, String color) {
        super(value, color);
    }

    public TextNameDTO() {
    }
}

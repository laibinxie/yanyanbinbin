package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class TextDTO extends BaseDataDTO{
    public TextDTO(String value, String color) {
        super(value, color);
    }

    public TextDTO() {
    }
}

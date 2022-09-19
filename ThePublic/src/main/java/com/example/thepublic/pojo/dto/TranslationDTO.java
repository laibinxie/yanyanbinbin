package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class TranslationDTO extends BaseDataDTO{
    public TranslationDTO(String value, String color) {
        super(value, color);
    }

    public TranslationDTO() {
    }
}

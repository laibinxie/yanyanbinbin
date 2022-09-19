package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class FeelsLikeNameDTO extends BaseDataDTO{
    public FeelsLikeNameDTO(String value, String color) {
        super(value, color);
    }

    public FeelsLikeNameDTO() {
    }
}

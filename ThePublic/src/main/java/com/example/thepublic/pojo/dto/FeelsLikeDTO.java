package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class FeelsLikeDTO extends BaseDataDTO{
    public FeelsLikeDTO(String value, String color) {
        super(value, color);
    }

    public FeelsLikeDTO() {
    }
}

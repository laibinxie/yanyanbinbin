package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class PmNameDTO extends BaseDataDTO{
    public PmNameDTO(String value, String color) {
        super(value, color);
    }

    public PmNameDTO() {
    }
}

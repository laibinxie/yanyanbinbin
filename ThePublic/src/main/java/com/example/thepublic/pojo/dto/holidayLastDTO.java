package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class holidayLastDTO extends BaseDataDTO{
    public holidayLastDTO(String value, String color) {
        super(value, color);
    }

    public holidayLastDTO() {
    }
}

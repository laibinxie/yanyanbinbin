package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class HolidayNameDTO extends BaseDataDTO{
    public HolidayNameDTO(String value, String color) {

        super(value, color);
    }

    public HolidayNameDTO() {
    }
}

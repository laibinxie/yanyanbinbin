package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class HolidayDTO extends BaseDataDTO {
    public HolidayDTO(String value, String color) {
        super(value, color);
    }

    public HolidayDTO() {
    }
}

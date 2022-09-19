package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class ContentDTO extends BaseDataDTO{
    public ContentDTO(String value, String color) {
        super(value, color);
    }

    public ContentDTO() {
    }
}

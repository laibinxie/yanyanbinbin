package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class NoteDTO extends BaseDataDTO{
    public NoteDTO(String value, String color) {

        super(value, color);
    }

    public NoteDTO() {
    }
}

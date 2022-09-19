package com.example.thepublic.pojo.dto;

import lombok.Data;

@Data
public class DataInfoDTO {
    private TextNameDTO textName;
    private TextDTO text;
    private TempDTO temp;
    private TempNameDTO tempName;
    private FeelsLikeDTO feelsLike;
    private FeelsLikeNameDTO feelsLikeName;
    private HolidayDTO holiday;
    private HolidayNameDTO holidayName;
    private holidayLastDTO holidayLast;
    private ContentDTO content;
    private NoteDTO note;
    private TranslationDTO translation;
    private MaxTempDTO  maxTemp;
    private MaxTempNameDTO  maxTempName;
    private MinTempDTO minTemp;
    private MinTempNameDTO minTempName;
    private PmNameDTO pm;
    private AirPm25DTO airPm25;
    private AirLevelNameDTO airLevelName;
    private AirLevelDTO airLevel;
}
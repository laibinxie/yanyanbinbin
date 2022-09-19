package com.example.thepublic.pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetWeatherApiResponse {
    public String cityid;

    public String week;

    public String city;

    public String wea;

    public String tem;

    public String tem1;

    public String tem2;
    @JsonProperty("air_pm25")
    public String airPm25;
    @JsonProperty("air_level")
    public String airLevel;
    @JsonProperty("air_tips")
    public String airTips;
}

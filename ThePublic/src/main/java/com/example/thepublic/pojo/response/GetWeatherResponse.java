package com.example.thepublic.pojo.response;

import com.example.thepublic.pojo.dto.NowInfoDTO;
import lombok.Data;

@Data
public class GetWeatherResponse {
    private String  code;
    private String  updateTime;
    private String  fxLink;
    private NowInfoDTO now;

}

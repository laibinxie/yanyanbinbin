package com.example.thepublic.pojo.response;

import com.example.thepublic.pojo.dto.DataDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetFollowerResponse {
    private Long total;
    private Long count;
    @JsonProperty("next_openid")
    private String nextOpenid;
    private DataDTO data;
}

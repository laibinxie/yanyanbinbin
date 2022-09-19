package com.example.thepublic.pojo.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetTokenResponse  {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private String expiresIn;
}

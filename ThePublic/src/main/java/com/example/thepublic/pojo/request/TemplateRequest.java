package com.example.thepublic.pojo.request;

import com.example.thepublic.pojo.dto.DataInfoDTO;
import lombok.Data;

@Data
public class TemplateRequest {

    public String touser;

    public String template_id;

    public String url;

    public DataInfoDTO data;


}

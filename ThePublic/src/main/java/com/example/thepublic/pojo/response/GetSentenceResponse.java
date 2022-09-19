package com.example.thepublic.pojo.response;

import lombok.Data;

import java.util.List;

@Data
public class GetSentenceResponse {
    public String sid;

    public String tts;
    //英文
    public String content;
    //中文
    public String note;

    public String love;

    public String translation;

    public String picture;

    public String picture2;

    public String caption;

    public String dateline;

    public String s_pv;

    public String sp_pv;

    public String fenxiang_img;

    public String picture3;

    public String picture4;

    public List<String> tags;
}

package com.example.thepublic.service.impl;

import com.example.thepublic.exception.MyHttpException;
import com.example.thepublic.pojo.dto.*;
import com.example.thepublic.pojo.request.TemplateRequest;
import com.example.thepublic.pojo.response.*;
import com.example.thepublic.service.HttpService;
import com.example.thepublic.service.ThePublicService;
import com.example.thepublic.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.thepublic.utils.CountDaysUtil.daysBetween;

@Service
public class ThePublicServiceImpl implements ThePublicService {
    @Autowired
    HttpService httpService;

    @Override
    public void sendMessage() throws MyHttpException {
        List<String> openids = getFollower();
        for (String openid : openids) {
            GetSentenceResponse sentence = getSentence();
            NowInfoDTO weather = getWeather();
            GetWeatherApiResponse weatherApi = getWeatherApi();
            String content = sentence.getContent();
            String note = sentence.getNote();
            String translation = "今天也要开心哦~~";
            String textName = "今天天气：";
            String text = weather.getText();
            String tempName = "当前气温：";
            String temp = weather.getTemp() + "℃";
            String feelsLikeName = "体感温度：";
            String feelsLike = weather.getFeelsLike() + "℃";
            String holidayName = "宝贝,我们在一起";
            String holiday = getHoliday();
            String holidayLast="天啦，，嘻嘻！！";
            String maxTempName = "最高气温：";
            String maxTemp = weatherApi.getTem1() + "℃";
            String minTempName = "最高低温：";
            String minTemp = weatherApi.getTem2() + "℃";
            String pm = "pm2.5值：";
            String airPm25 = weatherApi.getAirPm25();
            String airLevelName = "空气质量：";
            String airLevel = weatherApi.getAirLevel();
            TemplateRequest templateRequest = new TemplateRequest();
            templateRequest.setTouser(openid);
            templateRequest.setTemplate_id("Pu9xQsn7Sw20ZUeLEWFrXM4O2Uh4EJSnc-IYuzJZgdQ");
            DataInfoDTO data = new DataInfoDTO();
            data.setContent(new ContentDTO(content, ""));
            data.setNote(new NoteDTO(note, ""));
            data.setTranslation(new TranslationDTO(translation, ""));
            data.setTextName(new TextNameDTO(tempName, ""));
            data.setText(new TextDTO(text, ""));
            data.setTempName(new TempNameDTO(tempName, ""));
            data.setTemp(new TempDTO(temp, ""));
            data.setFeelsLikeName(new FeelsLikeNameDTO(feelsLikeName, ""));
            data.setFeelsLike(new FeelsLikeDTO(feelsLike, ""));
            data.setHolidayName(new HolidayNameDTO(holidayName, ""));
            data.setHoliday(new HolidayDTO(holiday, ""));
            data.setHolidayLast(new holidayLastDTO(holidayLast,""));
            data.setMaxTempName(new MaxTempNameDTO(maxTempName, ""));
            data.setMaxTemp(new MaxTempDTO(maxTemp, ""));
            data.setMinTempName(new MinTempNameDTO(minTempName, ""));
            data.setMinTemp(new MinTempDTO(minTemp, ""));
            data.setPm(new PmNameDTO(pm, ""));
            data.setAirPm25(new AirPm25DTO(airPm25, ""));
            data.setAirLevelName(new AirLevelNameDTO(airLevelName, ""));
            data.setAirLevel(new AirLevelDTO(airLevel, ""));
            templateRequest.setData(data);
            SendTemplateResponse sendTemplateResponse = sendTemplate(templateRequest);

        }
    }


    public String getToken() throws MyHttpException {
        String url = UriComponentsBuilder.fromUriString("https://api.weixin.qq.com").path("/cgi-bin/token")
                .queryParam("grant_type", "client_credential")
                .queryParam("appid", "wx9265575b9ba61202")
                .queryParam("secret", "081ab4216e4a46031ac58aab450e58ff")
                .build().toUri().toString();
        ResponseEntity<String> response = httpService.get(url, null);
        GetTokenResponse getTokenResponse = JsonUtil.parseObject(response.getBody(), GetTokenResponse.class);
        return getTokenResponse.getAccessToken();
    }

    public List<String> getFollower() throws MyHttpException {
        String url = UriComponentsBuilder.fromUriString("https://api.weixin.qq.com").path("/cgi-bin/user/get")
                .queryParam("access_token", getToken())
                .queryParam("next_openid", "")
                .build().toUri().toString();
        ResponseEntity<String> response = httpService.get(url, null);

        GetFollowerResponse getFollowerResponse = JsonUtil.parseObject(response.getBody(), GetFollowerResponse.class);
        DataDTO data = getFollowerResponse.getData();
        return data.getOpenid();
    }

    public NowInfoDTO getWeather() throws MyHttpException {
        String url = UriComponentsBuilder.fromUriString("https://devapi.qweather.com").path("/v7/weather/now")
                .queryParam("location", "101300407")
                .queryParam("key", "fe31e40ab1634a4eb5a15a62c27dedc1")
                .queryParam("gzip", "n")
                .build().toUri().toString();
        ResponseEntity<String> response = httpService.get(url, null);
        GetWeatherResponse getWeatherResponse = JsonUtil.parseObject(response.getBody(), GetWeatherResponse.class);
        return getWeatherResponse.getNow();
    }

    //101300401 来宾
    //101300404 象州
    //101300407 兴宾
//https://v0.yiketianqi.com/api?unescape=1&version=v63&appid=15945322&appsecret=y18CsbT4&cityid=101300404
    public GetWeatherApiResponse getWeatherApi() throws MyHttpException {
        String url = UriComponentsBuilder.fromUriString("https://v0.yiketianqi.com/").path("/api")
                .queryParam("unescape", "1")
                .queryParam("version", "v63")
                .queryParam("appid", "15945322")
                .queryParam("appsecret", "yMn3sXiD")
                .queryParam("cityid", "101300407")
                .build().toUri().toString();
        ResponseEntity<String> response = httpService.get(url, null);
        GetWeatherApiResponse getWeatherApiResponse = JsonUtil.parseObject(response.getBody(), GetWeatherApiResponse.class);
        return getWeatherApiResponse;
    }

    //http://open.iciba.com/dsapi/

    public GetSentenceResponse getSentence() throws MyHttpException {
        String url = UriComponentsBuilder.fromUriString("http://open.iciba.com").path("/dsapi/")
                .build().toUri().toString();
        ResponseEntity<String> response = httpService.get(url, null);
        GetSentenceResponse getSenterceResponse = JsonUtil.parseObject(response.getBody(), GetSentenceResponse.class);
        return getSenterceResponse;
    }


    /**
     * 发送模板
     */
    public SendTemplateResponse sendTemplate(TemplateRequest request) throws MyHttpException {
        String url = UriComponentsBuilder.fromUriString("https://api.weixin.qq.com").path("/cgi-bin/message/template/send")
                .queryParam("access_token", getToken())
                .build().toUri().toString();
        String body = JsonUtil.toJsonString(request);
        ResponseEntity<String> response = httpService.post(url, body);
        SendTemplateResponse sendTemplateResponse = JsonUtil.parseObject(response.getBody(), SendTemplateResponse.class);
        return sendTemplateResponse;
    }

    public String getHoliday() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime;
        Date NowTime;
        int togetherTime;
        try {
            startTime = simpleDateFormat.parse("2021-10-24");
            NowTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));//获得当前时间
            togetherTime = daysBetween(startTime, NowTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(togetherTime);
    }


}

package com.example.thepublic.controller;

import com.example.thepublic.exception.MyHttpException;
import com.example.thepublic.service.HttpService;
import com.example.thepublic.service.ThePublicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@Slf4j
@RequestMapping("text")
public class ThePublicController {
    @Autowired
    private ThePublicService thePublicService;

    @Autowired
    HttpService httpService;

    @GetMapping("sendMessage")
    public ResponseEntity<String> sendMessage() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    thePublicService.sendMessage();
                } catch (MyHttpException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.schedule(timerTask, time, 1000 * 60 * 60 * 24);
        return new ResponseEntity("succeed", HttpStatus.OK);
    }

}

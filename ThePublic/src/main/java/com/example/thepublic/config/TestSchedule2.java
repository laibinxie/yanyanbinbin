package com.example.thepublic.config;

import com.example.thepublic.exception.MyHttpException;
import com.example.thepublic.service.ThePublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestSchedule2 {
    @Autowired
    private ThePublicService thePublicService;
    //@Scheduled(cron = "0 30 23  * * ?")
    @Scheduled(cron = "0 33 * * * *")
    public void work() throws MyHttpException {
        thePublicService.sendMessage();
    }
}


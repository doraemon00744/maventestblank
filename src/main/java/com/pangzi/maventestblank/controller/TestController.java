package com.pangzi.maventestblank.controller;

import com.pangzi.maventestblank.service.TranslatorService;
import com.pangzi.maventestblank.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pangzi on 16/2/18.
 */
@RestController
public class TestController {
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private TranslatorService translatorService;

    @RequestMapping(value = "/weather/{cityName}", method = RequestMethod.GET)
    public String weather(@PathVariable String cityName) {
        String response = null;
        try {
            response = weatherService.getWeatherByCityName(cityName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    @RequestMapping(value = "/translate/{wordKey}", method = RequestMethod.GET)
    public String translate(@PathVariable String wordKey) {
        String response = null;
        try {
            response = translatorService.translate(wordKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}

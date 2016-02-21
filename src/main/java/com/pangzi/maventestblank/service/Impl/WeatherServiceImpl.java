package com.pangzi.maventestblank.service.Impl;

import com.pangzi.maventestblank.service.WeatherService;
import com.pangzi.maventestblank.utils.AxisInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Created by pangzi on 16/2/15.
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    @Qualifier("getWeatherByCityNameInvoker")
    private AxisInvoker axisInvoker;


    @Override
    public String getWeatherByCityName(String cityName) throws Exception{
        return axisInvoker.invokeWithString(cityName);
    }
}

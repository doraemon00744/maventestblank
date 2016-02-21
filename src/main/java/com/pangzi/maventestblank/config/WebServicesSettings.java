package com.pangzi.maventestblank.config;

import com.pangzi.maventestblank.utils.AxisInvoker;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by pangzi on 16/2/17.
 */
@Configuration
public class WebServicesSettings {
    @Bean(name = "getWeatherByCityNameInvoker")
    @ConfigurationProperties(prefix = "webServices.getWeatherByCityName")
    public AxisInvoker getWeatherByCityNameInvoker(){
        return new AxisInvoker();
    }

    @Bean(name = "translatorInvoker")
    @ConfigurationProperties(prefix = "webServices.translate")
    public AxisInvoker translatorInvoker(){
        return new AxisInvoker();
    }

}

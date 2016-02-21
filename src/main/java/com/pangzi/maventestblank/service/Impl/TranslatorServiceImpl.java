package com.pangzi.maventestblank.service.Impl;

import com.pangzi.maventestblank.service.TranslatorService;
import com.pangzi.maventestblank.utils.AxisInvoker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pangzi on 16/2/18.
 */
@Service
public class TranslatorServiceImpl implements TranslatorService {
    @Resource(name = "translatorInvoker")
    private AxisInvoker axisInvoker;
    @Override
    public String translate(String wordKey) throws Exception {
        return axisInvoker.invokeWithString(wordKey);
    }
}

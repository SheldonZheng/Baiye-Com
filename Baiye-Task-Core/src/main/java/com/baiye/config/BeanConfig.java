package com.baiye.config;

import com.google.common.collect.Maps;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by Baiye on 2017/3/5.
 */
@Component
public class BeanConfig {

    @Bean("taskFutureMap")
    public ConcurrentHashMap<String, ScheduledFuture> getTaskFutureMap()
    {
        return new ConcurrentHashMap<String,ScheduledFuture>();
    }

}

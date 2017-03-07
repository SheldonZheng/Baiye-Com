package com.baiye.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Baiye on 2017/3/5.
 */
@Configuration
public class BeanConfig {

    @Bean("taskFutureMap")
    public ConcurrentHashMap<String, ScheduledFuture> getTaskFutureMap()
    {
        return new ConcurrentHashMap<String,ScheduledFuture>();
    }

    @Bean("classLoaderCache")
    public LoadingCache<String,ClassLoader> classLoaderCache()
    {
        return CacheBuilder
                .newBuilder()
                .expireAfterAccess(1, TimeUnit.DAYS)
                .build(new CacheLoader<String, ClassLoader>() {
                    @Override
                    public ClassLoader load(String key) throws Exception {
                        return null;
                    }
                });

    }

}

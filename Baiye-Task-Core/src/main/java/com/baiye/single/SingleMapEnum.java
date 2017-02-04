package com.baiye.single;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by Baiye on 01/02/2017.
 */
public enum SingleMapEnum {

    LocalTaskFutureSingleMap(new ConcurrentHashMap<String, ScheduledFuture>());

    private Map map;

    private SingleMapEnum(Map map)
    {
        this.map = map;
    }

    public Map getMap()
    {
        return this.map;
    }

}

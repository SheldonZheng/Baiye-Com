package com.baiye.node;

import com.baiye.single.SingleMapEnum;

import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.function.BiConsumer;

/**
 * Created by Baiye on 2017/2/4.
 */
public class SimpleLocalNode implements Node{

    @Override
    public void init() {

    }

    @Override
    public void join() {
        //TODO
    }

    @Override
    public void exit() {
        Map<String,ScheduledFuture> tasks = SingleMapEnum.LocalTaskFutureSingleMap.getMap();
        if(tasks != null && tasks.size() > 0)
            tasks.forEach( (key,value) -> value.cancel(false) );
        //TODO
    }
}

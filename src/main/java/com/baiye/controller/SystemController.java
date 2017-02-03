package com.baiye.controller;

import com.baiye.single.SingleMapEnum;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by Baiye on 01/02/2017.
 */

@Controller
public class SystemController {

    @RequestMapping("/healthCheck")
    @ResponseBody
    public String healthCheck(){
        return "ok";
    }

    @RequestMapping("/runningTasks")
    @ResponseBody
    public List<String> runningTasks()
    {
        List<String> result = Lists.newArrayList();
        Map<String,ScheduledFuture> scheduledFutureMap = SingleMapEnum.LocalTaskFutureSingleMap.getMap();
        if(scheduledFutureMap != null && scheduledFutureMap.size() > 0)
        {
            for (Map.Entry<String, ScheduledFuture> entry : scheduledFutureMap.entrySet()) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}

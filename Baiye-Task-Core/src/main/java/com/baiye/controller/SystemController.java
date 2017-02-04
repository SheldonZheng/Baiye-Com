package com.baiye.controller;

import com.baiye.exception.BaiyeTaskException;
import com.baiye.helper.IOHelper;
import com.baiye.single.SingleMapEnum;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, String packagesToScan, @RequestParam MultipartFile jobJar) {
        Assert.notNull(jobJar, "jobJar can't be null.");
        Assert.notNull(packagesToScan, "packagesToScan can't be empty.");
        String jarFilePath = request.getContextPath() + "/jobs/" + jobJar.getOriginalFilename();
        try {
            IOHelper.writeFile(jarFilePath, jobJar.getBytes());
        } catch (IOException e) {
            throw new BaiyeTaskException(e);
        }
        return "forward:/masterSlaveJobSummaries";
    }
}

package com.baiye.controller;

import com.baiye.common.helper.ControllerHelper;
import com.baiye.exception.BaiyeTaskException;
import com.baiye.helper.IOHelper;
import com.baiye.service.TaskService;
import com.baiye.single.SingleMapEnum;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by Baiye on 2017/2/6.
 */
@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;


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

    @RequestMapping(value = "/uploadJar", method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request, String packagesToScan, @RequestParam MultipartFile jobJar) {
        Assert.notNull(jobJar, "jobJar can't be null.");
        Assert.notNull(packagesToScan, "packagesToScan can't be empty.");
        String jarFilePath = ControllerHelper.getRealPath(request,"/jobs").concat("/").concat(jobJar.getOriginalFilename());
        try {
            IOHelper.writeFile(jarFilePath, jobJar.getBytes());
            taskService.addTask(jarFilePath,packagesToScan);
        } catch (IOException e) {
            throw new BaiyeTaskException(e);
        }
        return "success add job!";
    }
}

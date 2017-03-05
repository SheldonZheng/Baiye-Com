package com.baiye.controller;

import com.baiye.config.CoreConfig;
import com.baiye.exception.BaiyeTaskException;
import com.baiye.helper.IOHelper;
import com.baiye.model.JsonResult;
import com.baiye.service.TaskService;
import com.baiye.single.SingleMapEnum;
import com.google.common.collect.Lists;
import org.aeonbits.owner.ConfigCache;
import org.apache.commons.collections4.MapUtils;
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

    private final CoreConfig config = ConfigCache.getOrCreate(CoreConfig.class);

    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "/runningTasks",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<List<String>> runningTasks()
    {
        List<String> tasks = taskService.runningTasks();
        return JsonResult.buildSuccessResult(tasks);
    }

    @RequestMapping(value = "/uploadJar", method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request, String packagesToScan, @RequestParam MultipartFile jobJar) {
        Assert.notNull(jobJar, "jobJar can't be null.");
        Assert.notNull(packagesToScan, "packagesToScan can't be empty.");
        String jarFilePath = config.jobJarBasePath().concat("/").concat(jobJar.getOriginalFilename());
        try {
            IOHelper.writeFile(jarFilePath, jobJar.getBytes());
            taskService.addTask(jarFilePath,packagesToScan);
        } catch (IOException e) {
            throw new BaiyeTaskException(e);
        }
        return "success add job!";
    }

    @RequestMapping(value = "/cacelTask",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<String> cancelTask(@RequestParam(value = "taskName")String taskName)
    {
        Assert.notNull(taskName);
        if(taskService.cancelTask(taskName)) {
            return JsonResult.buildSuccessResult("success cancel task:".concat(taskName));
        }
        else {
            return JsonResult.buildErrorResult("cancel task failed.");
        }
    }

}

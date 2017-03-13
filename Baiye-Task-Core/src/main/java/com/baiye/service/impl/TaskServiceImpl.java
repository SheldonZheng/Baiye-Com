package com.baiye.service.impl;

import com.baiye.container.SchedulerTaskLocalContainer;
import com.baiye.service.TaskService;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by Baiye on 2017/2/4.
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    @Qualifier("taskFutureMap")
    private Map<String,ScheduledFuture> taskFutureMap;

    @Autowired
    private SchedulerTaskLocalContainer schedulerTaskLocalContainer;

    @Override
    public boolean cancelTask(String taskName) {
        if(MapUtils.isNotEmpty(taskFutureMap))
        {
            ScheduledFuture future = taskFutureMap.get(taskName);
            if(future == null)
                return false;
            future.cancel(false);
            return true;
        }
        return false;
    }

    @Override
    public void addTask(String jarFilePath, String packageName) {
        try {
            schedulerTaskLocalContainer.addTasks(packageName,jarFilePath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> runningTasks() {
        List<String> result = Lists.newArrayList();
        if(MapUtils.isNotEmpty(taskFutureMap))
        {
            for (Map.Entry<String, ScheduledFuture> entry : taskFutureMap.entrySet()) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}

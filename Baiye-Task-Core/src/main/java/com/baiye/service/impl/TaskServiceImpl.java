package com.baiye.service.impl;

import com.baiye.container.SchedulerTaskLocalContainer;
import com.baiye.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Baiye on 2017/2/4.
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private SchedulerTaskLocalContainer schedulerTaskLocalContainer;

    @Override
    public void addTask(String jarFilePath, String packageName) {

    }
}

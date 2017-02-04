package com.baiye.container;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import com.baiye.helper.ClassHelper;
import com.baiye.task.SimpleTask;
import com.baiye.task.Task;

/**
 * Created by Baiye on 2017/1/19.
 */
public class SimpleTaskLocalContainer extends AbstractContainer{

    private ExecutorService executorService;

    public SimpleTaskLocalContainer() {
        super();
    }

    public SimpleTaskLocalContainer(Integer THREAD_POOL_SIZE) {
        super(THREAD_POOL_SIZE);
    }

    @Override
    protected void init() {
        this.executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    @Override
    public void addTasks(String packageName)
    {
            Map<Class,List<Method>> tasks = ClassHelper.getSimpleTaskMethodsAndClass(packageName);
            if(MapUtils.isNotEmpty(tasks))
            {
                doRunTasks(tasks);
            }

    }

    @Override
    public void addTasks(String packageName, String jarFilePath) {
        Map<Class,List<Method>> tasks = ClassHelper.getSimpleTaskMethodsAndClass(packageName,jarFilePath);
        if(MapUtils.isNotEmpty(tasks))
        {
            doRunTasks(tasks);
        }
    }

    private void doRunTasks(Map<Class,List<Method>> tasks)
    {
        tasks.forEach( (key,value) -> {
            if(CollectionUtils.isNotEmpty(value))
            {
                value.forEach(method -> {
                    Task task = new SimpleTask(ClassHelper.newInstance(key),method,new Object[]{});
                    executorService.execute(task);
                });
            }
        });
    }
}

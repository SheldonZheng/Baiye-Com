package com.baiye.container;

import com.baiye.annotation.SchedulerTask;
import com.baiye.helper.ClassHelper;
import com.baiye.task.SimpleTask;
import com.baiye.task.Task;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by Baiye on 28/01/2017.
 */
public class SchedulerTaskLocalContainer extends AbstractContainer{

    private ScheduledExecutorService executorService;


    public SchedulerTaskLocalContainer(String packageName) {
        super(packageName);
    }

    public SchedulerTaskLocalContainer(String packageName, Integer THREAD_POOL_SIZE) {
        super(packageName, THREAD_POOL_SIZE);
    }

    @Override
    protected void init() {
        this.executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
    }

    @Override
    public void run() {
        Set<Class<?>> classSet = ClassHelper.getBaiyeTaskClassAnnotation(packageName);
        if(CollectionUtils.isEmpty(classSet))
            return;

        for (Class<?> cls : classSet) {
            Object classInstance = null;
            try {
                classInstance = cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            List<Method> methodList = ClassHelper.getSchedulerTaskMethods(cls);
            if(CollectionUtils.isNotEmpty(methodList))
            {
                for (Method method : methodList) {
                    SchedulerTask schedulerTask = method.getAnnotation(SchedulerTask.class);
                    Task task = new SimpleTask(classInstance,method,new Object[]{});
                    ScheduledFuture scheduledFuture = executorService.scheduleAtFixedRate(task,schedulerTask.firstDelay(),schedulerTask.delay(), TimeUnit.MILLISECONDS);
                }
            }

        }
    }
}

package com.baiye.container;

import com.baiye.annotation.SchedulerTask;
import com.baiye.exception.BaiyeTaskException;
import com.baiye.helper.ClassHelper;
import com.baiye.single.SingleMapEnum;
import com.baiye.task.SimpleTask;
import com.baiye.task.Task;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Baiye on 28/01/2017.
 */
@Component
public class SchedulerTaskLocalContainer extends AbstractContainer{


    private Map<String,ScheduledFuture> scheduledFutureMap = SingleMapEnum.LocalTaskFutureSingleMap.getMap();

    public SchedulerTaskLocalContainer() {
        super();
    }

    public SchedulerTaskLocalContainer(String packageName, Integer THREAD_POOL_SIZE) {
        super(THREAD_POOL_SIZE);
    }

    @Override
    protected void init() {
        this.executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
    }

    @Override
    public void addTasks(String packageName)
    {
        Map<Class,List<Method>> tasks = ClassHelper.getSchedulerTaskMethodsAndClass(packageName);
        if(MapUtils.isNotEmpty(tasks))
        {
            tasks.forEach( (key,value) ->
            {
                if(CollectionUtils.isNotEmpty(value))
                {
                    value.forEach( method -> {
                        SchedulerTask schedulerTask = method.getAnnotation(SchedulerTask.class);
                        Task task = new SimpleTask(ClassHelper.newInstance(key),method,new Object[]{});
                        if(scheduledFutureMap.containsKey(schedulerTask.name()))
                            throw new BaiyeTaskException("已存在相同名称的任务");
                        ScheduledFuture scheduledFuture = executorService.scheduleAtFixedRate(task,schedulerTask.firstDelay(),schedulerTask.delay(), TimeUnit.MILLISECONDS);
                        scheduledFutureMap.put(schedulerTask.name(),scheduledFuture);
                    });
                }
            });
        }
    }
}

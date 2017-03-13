package com.baiye.container;

import com.baiye.annotation.SchedulerTask;
import com.baiye.annotation.TaskClass;
import com.baiye.exception.BaiyeTaskException;
import com.baiye.helper.ClassHelper;
import com.baiye.service.ClassScanerService;
import com.baiye.task.SimpleTask;
import com.baiye.task.Task;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Baiye on 28/01/2017.
 */
@Component
public class SchedulerTaskLocalContainer extends AbstractContainer {


    @Autowired
    @Qualifier("taskFutureMap")
    private Map<String, ScheduledFuture> scheduledFutureMap;

    @Autowired
    private ClassScanerService scanerService;

    public SchedulerTaskLocalContainer() {
        super();
    }

    public SchedulerTaskLocalContainer(Integer THREAD_POOL_SIZE) {
        super(THREAD_POOL_SIZE);
    }

    @Override
    protected void init() {
        this.executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
    }

    @Override
    public void addTasks(String packageName, String jarFilePath) throws MalformedURLException, ExecutionException {
        Set<Class<?>> classSet = scanerService.getClasses(packageName, jarFilePath, TaskClass.class);
        if (CollectionUtils.isNotEmpty(classSet)) {
            classSet.forEach(cls -> {
                List<Method> methodList = scanerService.getAnnotationMethods(cls, SchedulerTask.class);
                if (CollectionUtils.isNotEmpty(methodList)) {
                    methodList.forEach( method -> {
                        doRunTasks(cls,method);
                    });
                }
            });
        }
    }


    private void doRunTasks(Class cls, Method method) {

        SchedulerTask schedulerTask = method.getAnnotation(SchedulerTask.class);
        Task task = new SimpleTask(ClassHelper.newInstance(cls), method, new Object[]{});
        if (scheduledFutureMap.containsKey(schedulerTask.name()))
            throw new BaiyeTaskException("已存在相同名称的任务");
        ScheduledFuture scheduledFuture = executorService.scheduleAtFixedRate(task, schedulerTask.firstDelay(), schedulerTask.delay(), TimeUnit.MILLISECONDS);
        scheduledFutureMap.put(schedulerTask.name(), scheduledFuture);
    }
}

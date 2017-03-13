package com.baiye.container;

import com.baiye.annotation.SchedulerTask;
import com.baiye.annotation.TaskClass;
import com.baiye.annotation.TaskMethod;
import com.baiye.helper.ClassHelper;
import com.baiye.service.ClassScanerService;
import com.baiye.task.SimpleTask;
import com.baiye.task.Task;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Baiye on 2017/1/19.
 */
@Component("simpleTaskLocalContainer")
public class SimpleTaskLocalContainer extends AbstractContainer {

    @Autowired
    private ClassScanerService scanerService;

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
    public void addTasks(String packageName, String jarFilePath) throws MalformedURLException, ExecutionException {
        Set<Class<?>> classSet = scanerService.getClasses(packageName, jarFilePath, TaskClass.class);
        if (CollectionUtils.isNotEmpty(classSet)) {
            classSet.forEach(cls -> {
                List<Method> methodList = scanerService.getAnnotationMethods(cls, TaskMethod.class);
                if (CollectionUtils.isNotEmpty(methodList)) {
                    methodList.forEach( method -> {
                        doRunTask(cls,method);
                    });
                }
            });
        }
    }

    @Override
    public void doRunTask(Class cls, Method method) {
        Task task = new SimpleTask(ClassHelper.newInstance(cls), method, new Object[]{});
        executorService.execute(task);

    }
}

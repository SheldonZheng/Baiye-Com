package com.baiye.container;

import com.baiye.helper.ClassHelper;
import com.baiye.task.SimpleTask;
import com.baiye.task.Task;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * Created by Baiye on 2017/1/19.
 */
public class SimpleLocalContainer extends AbstractContainer{

    public SimpleLocalContainer(String packageName) {
        super(packageName);
    }

    public SimpleLocalContainer(String packageName, Integer THREAD_POOL_SIZE) {
        super(packageName, THREAD_POOL_SIZE);
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

            List<Method> methodList = ClassHelper.getSimpleTaskMethods(cls);
            if(CollectionUtils.isNotEmpty(methodList))
            {
                for (Method method : methodList) {
                    Task task = new SimpleTask(classInstance,method,new Object[]{});
                    executorService.execute(task);
                    /*try {
                        method.invoke(classInstance,new Object[]{});
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }*/
                }
            }

        }
        executorService.shutdown();
    }
}

package com.baiye.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Baiye on 28/01/2017.
 */
public class SimpleTask implements Task{

    private static final Logger logger = LoggerFactory.getLogger(SimpleTask.class);

    private Object classInstance;

    private Object[] params;

    private Method method;

    public SimpleTask(Object classInstance, Method method, Object...params) {
        this.classInstance = classInstance;
        this.params = params;
        this.method = method;
    }


    @Override
    public void run() {
        if(classInstance != null && params != null && method != null)
        {
            try {
                method.invoke(classInstance,params);
            } catch (IllegalAccessException e) {
                logger.error("run simple task error!{}",e);
            } catch (InvocationTargetException e) {
                logger.error("run simple task error!{}",e);
            }
        }
    }
}

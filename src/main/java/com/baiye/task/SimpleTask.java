package com.baiye.task;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Baiye on 28/01/2017.
 */
public class SimpleTask implements Task{

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
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

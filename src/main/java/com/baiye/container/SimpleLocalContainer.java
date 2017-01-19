package com.baiye.container;

import com.baiye.helper.ClassHelper;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
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

            List<Method> methodList = ClassHelper.getTaskMethods(cls);
            if(CollectionUtils.isNotEmpty(methodList))
            {
                for (Method method : methodList) {
                    try {
                        method.invoke(classInstance,new Object[]{});
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}

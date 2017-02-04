package com.baiye.helper;

import com.baiye.annotation.SchedulerTask;
import com.baiye.annotation.TaskClass;
import com.baiye.annotation.TaskMethod;
import com.baiye.util.ClassUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Baiye on 2017/1/17.
 */
public class ClassHelper {

    private static final Logger logger = LoggerFactory.getLogger(ClassHelper.class);

    public static Object newInstance(Class cls)
    {
        Object classInstance = null;
        try {
            classInstance = cls.newInstance();
        } catch (InstantiationException e) {
            logger.error("class new instance error!{}",e);
        } catch (IllegalAccessException e) {
            logger.error("class new instance error!{}",e);
        }
        return classInstance;
    }

    public static Set<Class<?>> getBaiyeTaskClassAnnotation(String packageName)
    {
        Set<Class<?>> allClassSet = ClassUtil.getClassSet(packageName);
        Set<Class<?>> classSet = Sets.newHashSet();
        if(CollectionUtils.isEmpty(allClassSet))
        {
            logger.error("未获取到ClassSet,packageName:{}",packageName);
            return null;
        }

        for (Class<?> cls : allClassSet) {
            if(cls.isAnnotationPresent(TaskClass.class))
                classSet.add(cls);
        }

        return classSet;
    }

    public static List<Method> getSimpleTaskMethods(Class<?> cls)
    {
        List<Method> methodList = Lists.newArrayList();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(TaskMethod.class))
                methodList.add(method);
        }
        return methodList;
    }

    public static List<Method> getSchedulerTaskMethods(Class<?> cls)
    {
        List<Method> methodList = Lists.newArrayList();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(SchedulerTask.class))
                methodList.add(method);
        }
        return methodList;
    }

    public static Map<Class,List<Method>> getSchedulerTaskMethodsAndClass(String packageName)
    {
        Map<Class,List<Method>> result = Maps.newConcurrentMap();
        Set<Class<?>> classSet = getBaiyeTaskClassAnnotation(packageName);
        if(CollectionUtils.isNotEmpty(classSet))
        {
            classSet.forEach(cls ->
            {
                List<Method> methods = getSchedulerTaskMethods(cls);
                if(CollectionUtils.isNotEmpty(methods))
                {
                    result.put(cls,methods);
                }
            });
        }
        return result;
    }

}

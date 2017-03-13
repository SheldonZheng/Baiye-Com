package com.baiye.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Created by hang.zheng on 2017/3/7.
 */
public interface ClassScanerService {

    Set<Class<?>> getClasses(String packageName,String jarFilePath) throws MalformedURLException, ExecutionException;

    Set<Class<?>> getClasses(String packageName,String jarFilePath,Class<? extends Annotation> annotation) throws MalformedURLException, ExecutionException;

    List<Method> getAnnotationMethods(Class cls, Class<? extends Annotation> annotation);

}

package com.baiye.classloader;

import io.netty.util.internal.ConcurrentSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by Baiye on 2017/1/17.
 */
public final class ClassHolder {

    private static Logger logger = LoggerFactory.getLogger(ClassHolder.class);

    private final static Set<Class> classSet = new ConcurrentSet<>();

    public static void addClass(Class cls)
    {
        if(cls != null)
        {
            logger.debug("将Class:{}添加到ClassSet中",cls);
            classSet.add(cls);
        }
    }

}

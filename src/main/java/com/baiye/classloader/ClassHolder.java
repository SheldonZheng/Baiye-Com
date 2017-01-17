package com.baiye.classloader;

import io.netty.util.internal.ConcurrentSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Created by Baiye on 2017/1/17.
 */
public final class ClassHolder {

    private Logger logger = LoggerFactory.getLogger(ClassHolder.class);

    private final Set<Class> classSet = new ConcurrentSet<>();


}

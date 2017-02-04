package com.baiye.annotation;

import java.lang.annotation.*;

/**
 * Created by Baiye on 2017/1/19.
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SchedulerTask {

    String name();

    long firstDelay();

    long delay();
}

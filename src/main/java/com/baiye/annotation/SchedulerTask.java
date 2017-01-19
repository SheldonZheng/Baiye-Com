package com.baiye.annotation;

/**
 * Created by Baiye on 2017/1/19.
 */
public @interface SchedulerTask {
    String name();
    long firstDelay();
    long delay();
}

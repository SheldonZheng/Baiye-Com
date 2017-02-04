package com.baiye.container;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Baiye on 2017/1/19.
 */
public abstract class AbstractContainer implements Container{

    private Integer DEFAULT_THREAD_POOL_SIZE = 100;

    protected Integer THREAD_POOL_SIZE = DEFAULT_THREAD_POOL_SIZE;

    protected String packageName;

    protected ScheduledExecutorService executorService;


    public AbstractContainer(String packageName)
    {
        this.packageName = packageName;
        init();
    }

    public AbstractContainer(String packageName,Integer THREAD_POOL_SIZE)
    {
        this.packageName = packageName;
        this.THREAD_POOL_SIZE = THREAD_POOL_SIZE;
        init();
    }

    protected abstract void init();

}

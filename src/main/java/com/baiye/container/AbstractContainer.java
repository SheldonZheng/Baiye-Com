package com.baiye.container;

import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Baiye on 2017/1/19.
 */
public abstract class AbstractContainer implements Container{

    private Integer DEFAULT_THREAD_POOL_SIZE = 100;

    protected Integer THREAD_POOL_SIZE = DEFAULT_THREAD_POOL_SIZE;

    protected ScheduledExecutorService executorService;

    public AbstractContainer()
    {
        init();
    }

    public AbstractContainer(Integer THREAD_POOL_SIZE)
    {
        this.THREAD_POOL_SIZE = THREAD_POOL_SIZE;
        init();
    }

    protected abstract void init();

}

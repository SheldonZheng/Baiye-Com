package com.baiye.container;

import java.util.concurrent.ExecutorService;

/**
 * Created by Baiye on 2017/1/19.
 */
public abstract class AbstractContainer implements Container{

    private Integer DEFAULT_THREAD_POOL_SIZE = 100;

    protected ExecutorService executorService;

    protected Integer THREAD_POOL_SIZE = DEFAULT_THREAD_POOL_SIZE;

    protected String packageName;

    public AbstractContainer(String packageName)
    {
        this.packageName = packageName;
    }

}

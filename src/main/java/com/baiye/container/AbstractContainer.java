package com.baiye.container;

/**
 * Created by Baiye on 2017/1/19.
 */
public abstract class AbstractContainer implements Container{
    private String packageName;

    public AbstractContainer(String packageName)
    {
        this.packageName = packageName;
    }

}
